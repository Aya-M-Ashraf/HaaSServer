package com.haas.webview.controller;

import com.haas.server.service.interfaces.UserService;
import commons.dto.UserDTO;
import javax.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

/**
 *
 * @author Hossam
 */
@Controller
@SessionAttributes
public class LoginController {

    @Autowired
    private UserService userServiceImpl;

    @RequestMapping("/login")
    public ModelAndView showPage() {
        return new ModelAndView("login", "user", new UserDTO());
    }

    @RequestMapping(value = "/showProfile", method = RequestMethod.POST)
    public ModelAndView onSubmit(@ModelAttribute("user") UserDTO user, BindingResult result, RedirectAttributes redirect, HttpServletRequest request) {

        user = userServiceImpl.getUserByEmail(user.getEmail());
        if (user == null) {
            return new ModelAndView("login", "user", new UserDTO());
        } else {
            request.getSession().setAttribute("loggedUser",user);
            return new ModelAndView("redirect:profile.htm");
        }
    }

}
