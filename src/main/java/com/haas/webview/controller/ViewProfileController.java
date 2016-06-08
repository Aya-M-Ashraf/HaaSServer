package com.haas.webview.controller;

import com.haas.server.entity.DeviceOldSessionDevices;
import com.haas.server.entity.UserUsesDevice;
import com.haas.server.service.interfaces.ConnectionService;
import com.haas.server.service.interfaces.DeviceService;
import commons.dto.UserDTO;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

/**
 *
 * @author Aya M. Ashraf
 */
@Controller
public class ViewProfileController {

    @Autowired
    private ConnectionService connectionServiceImpl;
    @Autowired
    private DeviceService deviceServiceImpl;

    @RequestMapping("/profile")
    public ModelAndView showProfile(HttpServletRequest request) {

        UserDTO user = (UserDTO) request.getSession().getAttribute("loggedUser");

        List<List<DeviceOldSessionDevices>> deviceOldHostSessionDevices = connectionServiceImpl.getPastHostConnections(user);
        List<List<DeviceOldSessionDevices>> deviceOldGuestSessionDevices = connectionServiceImpl.getPastGuestConnections(user);
        List<UserUsesDevice> userUsesDevices = deviceServiceImpl.getUserDevices(user);

        ModelAndView model = new ModelAndView("profile");
        model.addObject("asHostList", deviceOldHostSessionDevices);
        model.addObject("asGuestList", deviceOldGuestSessionDevices);
        model.addObject("devicesList", userUsesDevices);
        return model;
    }
}
