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
    protected ModelAndView onSubmit(@ModelAttribute("user") UserDTO user,HttpServletRequest request , BindingResult result) throws Exception {
        UserDTO userDTO = (UserDTO) user;
        userDTO.setSilverCoins(100);
        userDTO.setGoldenCoins(100);
        userServiceImpl.addUser(userDTO);
         request.getSession().setAttribute("loggedUser", userDTO);
        return new ModelAndView("profile", "user", user);
    }
}
