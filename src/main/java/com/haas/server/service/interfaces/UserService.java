package com.haas.server.service.interfaces;

import commons.dto.UserDTO;
import java.util.ArrayList;
import java.util.HashMap;

/**
 *
 * @author Aya M. Ashraf
 */
public interface UserService {

    public UserDTO getUserByEmail(String email);

    public UserDTO updateUserPassword(String email, String phone);

    public ArrayList transferCoinsToUser(String coinsType, double coinsCount, String senderEmail, String receiverEmail);

    public String generateRandomPassword();

    public boolean updateUser(UserDTO user);

    public UserDTO getUserByPhone(String phone);

    public ArrayList<Object> registerUser(UserDTO userDto);

    public long getTotalNumberOfUsers();

    public long getTotalNumberOfMaleUsers();

    public long getTotalNumberOfFemaleUsers();

    public HashMap<String, Integer> getCityDistribution();
    
}
