package com.haas.webview.controller;

import com.haas.server.service.interfaces.UserService;
import commons.dto.UserDTO;
import java.util.ArrayList;
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
 * @author Aya M. Ashraf
 */
@Controller
public class RegisterController {

    @Autowired
    private UserService userServiceImpl;

    @RequestMapping("/register")
    public ModelAndView showPage() {
        return new ModelAndView("register", "user", new UserDTO());
    }

    @RequestMapping(value = "/addUser", method = RequestMethod.POST)
    public ModelAndView onSubmit(@ModelAttribute("user") @Valid UserDTO user,Errors result ,HttpServletRequest request ) {
       
        if (result.hasErrors()) {
            return new ModelAndView("register");
        }

        user.setSilverCoins(100);
        user.setGoldenCoins(100);
        
        ArrayList<Object> resultList = userServiceImpl.registerUser(user);
        if((boolean)resultList.get(2)){
             request.getSession().setAttribute("loggedUser", (UserDTO)resultList.get(0));
        }else{ 
            return new ModelAndView("register", "message", (String)resultList.get(1)); 
        }
       
        return new ModelAndView("redirect:profile.htm");
    }
}
