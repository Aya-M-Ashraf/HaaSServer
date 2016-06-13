package com.haas.webview.controller;

import com.haas.server.service.interfaces.UserService;
import com.haas.server.utils.PasswordSenderMail;
import com.haas.webview.bean.ForgotPasswordBean;
import commons.dto.UserDTO;
import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

/**
 *
 * @author Hossam
 */
@Controller
public class ForgotPasswordController {

    @Autowired
    private UserService userServiceImpl;

    @RequestMapping("/forgotPassword")
    public ModelAndView showPage() {
        return new ModelAndView("forgotPassword", "user", new ForgotPasswordBean());
    }

    @RequestMapping(value = "/retrievingPassword", method = RequestMethod.POST)
    public ModelAndView onSubmit(@ModelAttribute("user") @Valid ForgotPasswordBean user, Errors result, HttpServletRequest request) {
       
        if(result.hasErrors()){
            return new ModelAndView("forgotPassword"); 
        }
        
        UserDTO userDTO = userServiceImpl.updateUserPassword(user.getEmail(), user.getPhone());
        if (userDTO == null) {//No such user
            ModelAndView model = new ModelAndView("forgotPassword");
            model.addObject("message","This email doesn't belong to any user");
            return model;
        } else {//success retrieving password
            PasswordSenderMail.generateAndSendEmail(userDTO.getPassword(), userDTO.getEmail());
            return new ModelAndView("redirect:login.htm");

        }

    }

}
