package com.haas.webview.controller;

import com.haas.server.service.interfaces.UserService;
import commons.dto.UserDTO;
import java.util.ArrayList;
import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;

/**
 *
 * @author Aya M. Ashraf
 */
@Controller
@SessionAttributes
public class RegisterController {

    @Autowired
    private UserService userServiceImpl;

    @RequestMapping("/register")
    public ModelAndView showPage() {
        return new ModelAndView("register", "user", new UserDTO());
    }

    @RequestMapping(value = "/addUser", method = RequestMethod.POST)
    protected ModelAndView onSubmit(@ModelAttribute("user") @Valid UserDTO user, HttpServletRequest request, BindingResult result) throws Exception {
        if (result.hasErrors()) {
            return new ModelAndView("register");
        }

        UserDTO userDTO = (UserDTO) user;
        userDTO.setSilverCoins(100);
        userDTO.setGoldenCoins(100);
        ArrayList<Object> resultList = userServiceImpl.registerUser(userDTO);
        request.getSession().setAttribute("loggedUser", resultList.get(0));
        return new ModelAndView("profile");
    }
}
