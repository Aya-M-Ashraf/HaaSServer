package com.haas.webview.controller;

import commons.dto.UserDTO;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

/**
 *
 * @author Aya M. Ashraf
 */
@Controller
public class ViewProfileController {
      
   @RequestMapping("/profile")
    public ModelAndView showProfile(@ModelAttribute UserDTO user) {  
        return new ModelAndView("profile", "user",user);        
    }    
}
