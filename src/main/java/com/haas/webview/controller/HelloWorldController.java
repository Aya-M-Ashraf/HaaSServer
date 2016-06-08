package com.haas.webview.controller;

import org.springframework.stereotype.Controller;  
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;  
import org.springframework.web.servlet.ModelAndView;  
/**
 *
 * @author Aya M. Ashraf
 */
@Controller  
public class HelloWorldController {  
    @RequestMapping("/hello")  
    public ModelAndView helloWorld(@ModelAttribute("message") String message) {  
        return new ModelAndView("hello", "message", message);  
    }  
}  
