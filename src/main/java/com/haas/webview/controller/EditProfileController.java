package com.haas.webview.controller;

import com.haas.server.service.interfaces.UserService;
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
public class EditProfileController {

    @Autowired
    private UserService userServiceImpl;

    @RequestMapping("/editProfile")
    public ModelAndView showPage() {
        return new ModelAndView("editProfile", "user", new UserDTO());
    }

    @RequestMapping(value = "/updateUser", method = RequestMethod.POST)
    public ModelAndView onSubmit(@ModelAttribute("user") @Valid UserDTO user, BindingResult result, HttpServletRequest request) {

        if (result.hasErrors()) {
            return new ModelAndView("editProfile");
        }

        UserDTO userOrigin = (UserDTO) request.getSession().getAttribute("loggedUser");
        UserDTO userModefied = (UserDTO) user;
        userModefied.setUserId(userOrigin.getUserId());
        userModefied.setEmail(userOrigin.getEmail());
        userModefied.setGender(userOrigin.getGender());
        userModefied.setCountry(userOrigin.getCountry());
        userModefied.setSilverCoins(userOrigin.getSilverCoins());
        userModefied.setGoldenCoins(userOrigin.getGoldenCoins());
        userServiceImpl.updateUser(userModefied);
        request.getSession().setAttribute("loggedUser", userModefied);
        return new ModelAndView("profile");

    }

}
