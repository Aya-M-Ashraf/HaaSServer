package com.haas.server.ws;

import com.haas.server.service.interfaces.DeviceService;
import commons.dto.UserDTO;
import commons.ws.Constants;
import commons.ws.Result;
import java.util.ArrayList;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import com.haas.server.service.interfaces.UserService;
import com.haas.server.utils.PasswordSenderMail;
import com.haas.server.utils.Validation;
import javax.ws.rs.FormParam;
import javax.ws.rs.POST;

@Path("/user")
@Component
public class UserWS {

    @Autowired
    private UserService userServiceImpl;

    @Autowired
    private DeviceService deviceServiceImpl;

    public UserWS() {
    }

    @POST
    @Path("/register")
    @Produces(MediaType.APPLICATION_JSON)
    public Result register(@FormParam(Constants.EMAIL) String email, @FormParam(Constants.F_NAME) String fName, @FormParam(Constants.L_NAME) String lName, @FormParam(Constants.PHONE) String phone, @FormParam(Constants.PASSWORD) String password) {

        Result result = new Result();
        UserDTO userDto = new UserDTO();
        userDto.setEmail(email);
        userDto.setFirstName(fName);
        userDto.setLastName(lName);
        userDto.setPhone(phone);
        userDto.setPassword(password);
        userDto.setGoldenCoins(100);
        userDto.setSilverCoins(100);
        ArrayList<Object> resultList = userServiceImpl.registerUser(userDto);

        if (resultList.get(0) != null) {
            result.setSuccess(true);
            result.setObj(resultList.get(0));
            result.setMsg(resultList.get(1).toString());
            result.setCode("register");
        } else {
            result.setSuccess(false);
            result.setObj(resultList.get(0));
            result.setMsg(resultList.get(1).toString());
            result.setCode("register");
        }
        return result;

//        if (!Validation.mobileValidation(phone) || userServiceImpl.getUserByPhone(phone) != null) {
//            System.out.println("mobile");
//            result.setSuccess(false);
//            result.setMsg("This phone is already registered");
//            result.setCode("register");
//            result.setObj(null);
//            return result;
//        } else if (!Validation.eMailValidation(email) || userServiceImpl.getUserByEmail(email) != null) {
//            System.out.println("email");
//            result.setSuccess(false);
//            result.setMsg("user's email is not valid");
//            result.setCode("register");
//            result.setObj(null);
//            return result;
//        } else {
//            UserDTO userDto = new UserDTO();
//            userDto.setEmail(email);
//            userDto.setFirstName(fName);
//            userDto.setLastName(lName);
//            userDto.setPhone(phone);
//            userDto.setPassword(password);
//            userDto.setGoldenCoins(100);
//            userDto.setSilverCoins(100);
//            userDto = userServiceImpl.addUser(userDto);
//
//            if (userDto != null) {
//                result.setSuccess(true);
//                result.setObj(userDto);
//                result.setMsg("User added Successfully");
//                result.setCode("register");
//            } else {
//                result.setSuccess(false);
//                result.setObj(null);
//                result.setMsg("user can't be added");
//                result.setCode("register");
//            }
//            return result;
//        }
    }

    @GET
    @Path("/viewProfile")
    @Produces(MediaType.APPLICATION_JSON)
    public Result viewProfile(@QueryParam(Constants.EMAIL) String email) {
        Result result = new Result();
        UserDTO user = userServiceImpl.getUserByEmail(email);
        if (user == null) {
            result.setSuccess(false);
            result.setMsg("This Email doesn't belong to anyone");
            result.setObj(null);
            result.setCode("viewProfile");
        } else {
            result.setSuccess(true);
            result.setMsg("Success Message");
            result.setObj(user);
            result.setCode("viewProfile");
        }
        return result;
    }

    @POST
    @Path("/updateProfile")
    @Produces(MediaType.APPLICATION_JSON)
    public Result updateProfile(@FormParam(Constants.EMAIL) String email, @FormParam(Constants.F_NAME) String firstName, @FormParam(Constants.L_NAME) String lastName, @FormParam(Constants.PASSWORD) String newPassword, @FormParam(Constants.OLD_PASSWORD) String oldPassword, @FormParam(Constants.PHONE) String phone) {
        Result result = new Result();
        UserDTO user = userServiceImpl.getUserByEmail(email);
        UserDTO phoneUser = userServiceImpl.getUserByPhone(phone);
        if (user == null) {
            result.setSuccess(false);
            result.setMsg("This Email doesn't belong to anyone");
            result.setObj(null);
            result.setCode("updateProfile");

        } else if (phoneUser != null && !phoneUser.getEmail().equals(email)) {
            result.setSuccess(false);
            result.setMsg("This phone number is already registered");
            result.setObj(null);
            result.setCode("updateProfile");

        } else if (!user.getPassword().equals(oldPassword)) {
            result.setSuccess(false);
            result.setMsg("Your old password is incorrect");
            result.setObj(new UserDTO());
            result.setCode("updateProfile");

        } else {
            user.setFirstName(firstName);
            user.setLastName(lastName);
            user.setPassword(newPassword);
            user.setPhone(phone);
            userServiceImpl.updateUser(user);

            result.setSuccess(true);
            result.setMsg("Your profile has been updated successfully");
            result.setObj(user);
            result.setCode("updateProfile");
        }
        return result;
    }

    @POST
    @Path("/login")
    @Produces(MediaType.APPLICATION_JSON)
    public Result login(@FormParam(Constants.EMAIL) String email, @FormParam(Constants.PASSWORD) String password, @FormParam(Constants.SERIAL_NUMBER) String serialNumber) {
        Result result = new Result();

        if (deviceServiceImpl.linkDevice(email, serialNumber)) {
            UserDTO user = userServiceImpl.getUserByEmail(email);
            if (user == null) {
                result.setSuccess(false);
                result.setMsg("This Email doesn't belong to anyone");
                result.setObj(new UserDTO());
                result.setCode("login");
                return result;

            } else if (!user.getPassword().equals(password)) {
                result.setSuccess(false);
                result.setMsg("Password is incorrect");
                result.setObj(new UserDTO());
                result.setCode("login");
                return result;

            } else {
                result.setSuccess(true);
                result.setMsg("login is done successfully");
                result.setObj(user);
                result.setCode("login");
                return result;
            }
        } else {
            result.setSuccess(false);
            result.setMsg("Linking Device Error");
            result.setObj(new UserDTO());
            result.setCode("login");
            return result;
        }
    }

    @GET
    @Path("/transfer")
    @Produces(MediaType.APPLICATION_JSON)
    public Result transferCoins(@QueryParam(Constants.COINS_TYPE) String coinsType, @QueryParam(Constants.COINS_COUNT) double coinsCount, @QueryParam(Constants.SENDER_EMAIL) String senderEmail, @QueryParam(Constants.RECEIVER_EMAIL) String receiverEmail) {
        Result result = new Result();
        ArrayList resultArrayList = userServiceImpl.transferCoinsToUser(coinsType, coinsCount, senderEmail, receiverEmail);
        if (resultArrayList.size() > 0) {
            String message = (String) resultArrayList.get(0);
            boolean success = (Boolean) resultArrayList.get(1);
            result.setMsg(message);
            result.setSuccess(success);
            result.setCode("transfer");
            result.setObj(new UserDTO());
        }
        return result;
    }

    @GET
    @Path("/retrievePassword")
    @Produces(MediaType.APPLICATION_JSON)
    public Result retrievePassword(@QueryParam(Constants.EMAIL) String email, @QueryParam(Constants.PHONE) String phone) {
        Result result = new Result();
        UserDTO user = userServiceImpl.updateUserPassword(email, phone);
        if (user == null) {
            result.setSuccess(false);
            result.setMsg("The Entered Values are not Valid");
            result.setObj(null);
            result.setCode("retrievePassword");
        } else {
            PasswordSenderMail.generateAndSendEmail(user.getPassword(), user.getEmail());
            result.setSuccess(true);
            result.setMsg("Your New Password Has Been Sent To Your Registered E-Mail Address !");
            result.setObj(null);
            result.setCode("retrievePassword");
        }
        return result;
    }
}
