package com.haas.webview.controller;

import com.haas.server.service.interfaces.UserService;
import com.haas.server.utils.PasswordSenderMail;
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
public class ForgotPasswordController {

    @Autowired
    private UserService userServiceImpl;

    @RequestMapping("/forgotPassword")
    public ModelAndView showPage() {
        return new ModelAndView("forgotPassword", "user", new UserDTO());
    }

    @RequestMapping(value = "/retrievingPassword", method = RequestMethod.POST)
    public ModelAndView onSubmit(@ModelAttribute("user") UserDTO user, BindingResult result, HttpServletRequest request) {
        UserDTO userDTO = userServiceImpl.updateUserPassword(user.getEmail(), user.getPhone());
        if (user == null) {//No such user
            return new ModelAndView("forgotPassword", "user", new UserDTO());
        } else {//success retrieving password
            PasswordSenderMail.generateAndSendEmail(userDTO.getPassword(), userDTO.getEmail());
            return new ModelAndView("redirect:login.htm");

        }

    }

}
