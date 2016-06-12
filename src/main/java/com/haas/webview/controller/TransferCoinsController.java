package com.haas.webview.controller;

import com.haas.webview.bean.TransferringOperationBean;
import com.haas.server.service.interfaces.UserService;
import java.util.ArrayList;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

/**
 *
 * @author Aya M. Ashraf
 */
@Controller
public class TransferCoinsController {

    @Autowired
    private UserService userServiceImpl;

    @RequestMapping("/transferCoins")
    public ModelAndView showPage() {
        return new ModelAndView("transferCoins", "transferringOperation", new TransferringOperationBean());
    }

    @RequestMapping("/submitTransfer")
    public ModelAndView transferCoins(@ModelAttribute("transferringOperation") @Valid TransferringOperationBean operation, BindingResult result) {
        if (result.hasErrors()) {
           return new ModelAndView("transferCoins");
        }

        String message = "null";
        ArrayList resultArrayList = userServiceImpl.transferCoinsToUser(operation.getCoinsType(), operation.getCoinsCount(), operation.getSenderMail(), operation.getReceiverMail());
        if (resultArrayList.size() > 0) {
            message = (String) resultArrayList.get(0);
        }
        return new ModelAndView("transferCoins", "message", message);
    }

}
