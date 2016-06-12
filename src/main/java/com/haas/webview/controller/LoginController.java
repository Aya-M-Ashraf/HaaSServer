package com.haas.webview.controller;

import com.haas.server.service.interfaces.UserService;
import com.haas.webview.bean.LoginBean;
import commons.dto.UserDTO;
import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

/**
 *
 * @author Hossam
 */
@Controller
public class LoginController {

    @Autowired
    private UserService userServiceImpl;

    @RequestMapping("/login")
    public ModelAndView showPage() {
        return new ModelAndView("login", "user", new LoginBean());
    }

    @RequestMapping(value = "/showProfile", method = RequestMethod.POST)
    public ModelAndView onSubmit(@ModelAttribute("user") @Valid LoginBean user, BindingResult result, HttpServletRequest request) {

        if (result.hasErrors()) {
            return new ModelAndView("login");
        }

        UserDTO userDTO = userServiceImpl.getUserByEmail(user.getEmail());
        if (user == null) {
            return new ModelAndView("login", "user", new UserDTO());
        } else if (userDTO.getPassword().equals(user.getPassword())) {
            request.getSession().setAttribute("loggedUser", userDTO);
            return new ModelAndView("redirect:profile.htm");
        } else {
            return new ModelAndView("login", "user", new LoginBean());
        }
    }

}
