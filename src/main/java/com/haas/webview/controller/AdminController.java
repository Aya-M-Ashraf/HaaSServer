package com.haas.webview.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

/**
 *
 * @author Aya M. Ashraf
 */
@Controller
public class AdminController {
    @RequestMapping("/adminHome")
    public ModelAndView showPage() {        
        return new ModelAndView("adminHome");        
    }    
}
