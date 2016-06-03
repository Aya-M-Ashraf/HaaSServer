/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.haas.webview.controller;

import com.haas.server.service.interfaces.UserService;
import commons.dto.UserDTO;
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
    
    @RequestMapping(value = "/getUserByEmail", method = RequestMethod.POST)    
    ModelAndView onSubmit(@ModelAttribute("userDTO") UserDTO user, BindingResult result){
        UserDTO userDTO ;
        user = userServiceImpl.getUserByEmail(user.getEmail());
        if(user==null)
            return new ModelAndView("login","user", new UserDTO());
        else
            return new ModelAndView("profile", "user", user);
    }

}
