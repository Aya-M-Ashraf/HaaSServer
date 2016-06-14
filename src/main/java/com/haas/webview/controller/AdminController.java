package com.haas.webview.controller;

import com.haas.server.service.interfaces.ConnectionService;
import com.haas.server.service.interfaces.DeviceService;
import com.haas.server.service.interfaces.UserService;
import com.haas.webview.bean.AdminReportBean;
import com.haas.webview.bean.LoginBean;
import commons.dto.UserDTO;
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
public class AdminController {

    @Autowired
    private UserService userServiceImpl;
    @Autowired
    private ConnectionService connectionServiceImpl;
    @Autowired
    private DeviceService deviceServiceImpl;

    @RequestMapping("/adminHome")
    public ModelAndView showPage(HttpServletRequest request) {

        if (request.getSession(false) != null && request.getSession(false).getAttribute("loggedUser") != null) {
            UserDTO loggedUser = (UserDTO) request.getSession(false).getAttribute("loggedUser");
            if (loggedUser.getEmail().equalsIgnoreCase("admin@admin.com")) {
                AdminReportBean reportBean = new AdminReportBean();
                reportBean.setUsersCount(userServiceImpl.getTotalNumberOfUsers());
                reportBean.setDevicesCount(deviceServiceImpl.getTotalNumberOfSharedDevices());
                reportBean.setFemaleUsersCount(userServiceImpl.getTotalNumberOfFemaleUsers());
                reportBean.setMaleUsersCount(userServiceImpl.getTotalNumberOfMaleUsers());
                reportBean.setConnectionsCount(connectionServiceImpl.getTotalNumberOfConnections());
                reportBean.setTotalMegaBytes(connectionServiceImpl.getTotalNumberOfMegabytes());
                return new ModelAndView("adminHome", "reportBean", reportBean);
            } else {
                return new ModelAndView("errorPage", "message", "Sorry You are not authorized ");
            }
        } else {
            return new ModelAndView("login", "user", new LoginBean());
        }
    }
}
