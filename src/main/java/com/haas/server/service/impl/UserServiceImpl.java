package com.haas.server.service.impl;

import commons.dto.UserDTO;
import com.haas.server.dao.interfaces.UserDao;
import com.haas.server.dao.interfaces.UserTransferCoinsDAO;
import com.haas.server.entity.User;
import com.haas.server.entity.UserTransferCoinsUser;
import com.haas.server.entity.key.UserTransferCoinsUserPK;
import java.util.ArrayList;
import java.util.Date;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.haas.server.service.interfaces.UserService;
import com.haas.server.utils.EntityMapper;
import java.security.SecureRandom;
import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author Aya M. Ashraf
 */
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserDao userDaoImpl;
    @Autowired
    private UserTransferCoinsDAO userTransferCoinsDAO;
    @Autowired
    private EntityMapper entityMapper;

    private static final Random RANDOM = new SecureRandom();
    private static final int PASSWORD_LENGTH = 8;

    public UserServiceImpl() {
        
    }

    @Override
    public boolean addUser(UserDTO userDto) {
        try {
            User user = entityMapper.mapUserDtoToUser(userDto);
            user = userDaoImpl.makePersistent(user);
            return true;
        } catch (Exception ex) {
            Logger.getLogger(UserServiceImpl.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
    }

    @Override
    public UserDTO getUserByEmail(String email) {
        User user = userDaoImpl.getUserByEmail(email);
        if (user == null) {
            return null;
        } else {
            return entityMapper.mapUserToUserDto(user);
        }
    }

    @Override
    public UserDTO getUserByPhone(String phone) {
        User user = userDaoImpl.getUserByPhone(phone);
        if (user == null) {
            return null;
        } else {
            return entityMapper.mapUserToUserDto(user);
        }
    }

    @Override
    public UserDTO updateUserPassword(String email, String phone) {
        User user = userDaoImpl.getUserByEmail(email);
        if (user == null) {
            return null;
        } else if (user.getPhone().equals(phone)) {
            try {
                user.setPassword(generateRandomPassword());
                userDaoImpl.update(user);
                return entityMapper.mapUserToUserDto(user);
            } catch (Exception ex) {
                Logger.getLogger(UserServiceImpl.class.getName()).log(Level.SEVERE, null, ex);
                return null;
            }
        } else {
            return null;
        }
    }

    @Override
    @Transactional
    public ArrayList transferCoinsToUser(String coinsType, double coinsCount, String senderEmail, String receiverEmail) {
        ArrayList result = new ArrayList();
        User lenderUser = userDaoImpl.getUserByEmail(senderEmail);
        User borrowerUser = userDaoImpl.getUserByEmail(receiverEmail);

        //----------- if any of the users is null then the transaction can't be done--------------
        if (lenderUser != null && borrowerUser != null) {

            if (coinsType.equalsIgnoreCase("golden")) {

                double senderCoinsAfterDeduction = lenderUser.getGoldenCoins() - coinsCount;
                //-------------- if the sender coins after transferring the coins are less than zero then its a fraud operation ------------------
                if (senderCoinsAfterDeduction >= 0) {
                    borrowerUser.setGoldenCoins(borrowerUser.getGoldenCoins() + coinsCount);
                    lenderUser.setGoldenCoins(lenderUser.getGoldenCoins() - coinsCount);

                    //---------- update both sender and receiver users-------------------------
                    try {
                        userDaoImpl.update(lenderUser);
                        userDaoImpl.update(borrowerUser);

                        //------------ Update table user_transfer_coins_user table -------------------------------
                        UserTransferCoinsUserPK userTransferCoinsUserPK = new UserTransferCoinsUserPK();
                        userTransferCoinsUserPK.setBorrowerUserId(borrowerUser.getUserId());
                        userTransferCoinsUserPK.setLenderUserId(lenderUser.getUserId());
                        userTransferCoinsUserPK.setTransactionTimestamp(new Date());

                        UserTransferCoinsUser userTransferCoinsUser = new UserTransferCoinsUser();
                        userTransferCoinsUser.setLenderUser(lenderUser);
                        userTransferCoinsUser.setBorrowerUser(borrowerUser);
                        userTransferCoinsUser.setUserTransferCoinsUserPK(userTransferCoinsUserPK);
                        userTransferCoinsUser.setCoinsAmount(coinsCount);
                        userTransferCoinsDAO.makePersistent(userTransferCoinsUser);

                        System.out.println("Successful coins transferring");
                        result.add("Successful coins transferring");
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                    result.add(true);
                    return result;
                } else {

                    System.out.println("Sender golden coins are too few to make this transaction");
                    result.add("Sender golden coins are too few to make this transaction");
                    result.add(false);
                    return result;
                }
            } else if (coinsType.equalsIgnoreCase("silver")) {

                double senderCoinsAfterDeduction = lenderUser.getSilverCoins() - coinsCount;
                //-------------- if the sender coins after transferring the coins are less than zero then its a fraud operation ------------------
                if (senderCoinsAfterDeduction >= 0) {
                    try {
                        borrowerUser.setSilverCoins(borrowerUser.getSilverCoins() + coinsCount);
                        lenderUser.setSilverCoins(lenderUser.getSilverCoins() - coinsCount);
                        
                        //---------- update both sender and receiver users-------------------------
                        userDaoImpl.update(lenderUser);
                        userDaoImpl.update(borrowerUser);
                        
                        //------------ Update table user_transfer_coins_user table -------------------------------
                        UserTransferCoinsUserPK userTransferCoinsUserPK = new UserTransferCoinsUserPK();
                        userTransferCoinsUserPK.setBorrowerUserId(borrowerUser.getUserId());
                        userTransferCoinsUserPK.setLenderUserId(lenderUser.getUserId());
                        userTransferCoinsUserPK.setTransactionTimestamp(new Date());
                        
                        UserTransferCoinsUser userTransferCoinsUser = new UserTransferCoinsUser();
                        userTransferCoinsUser.setLenderUser(lenderUser);
                        userTransferCoinsUser.setBorrowerUser(borrowerUser);
                        userTransferCoinsUser.setUserTransferCoinsUserPK(userTransferCoinsUserPK);
                        userTransferCoinsUser.setCoinsAmount(coinsCount);
                        userTransferCoinsDAO.makePersistent(userTransferCoinsUser);
                        
                        System.out.println("Successful coins transferring");
                        result.add("Successful coins transferring");
                        result.add(true);
                        return result;
                    } catch (Exception ex) {
                        Logger.getLogger(UserServiceImpl.class.getName()).log(Level.SEVERE, null, ex);
                    }
                } else {
                    System.out.println("Sender silver coins are too few to make this transaction");
                    result.add("Sender silver coins are too few to make this transaction");
                    result.add(false);
                    return result;
                }
            }
            //------- if any of the above conditions is not fullfilled then this is a transaction failure---------------
            System.out.println("Not defined coins type");
            result.add("Not defined coins type");
            result.add(false);
            return result;
        } else {
            System.out.println("Sender and receivers both must be an existing real users on the system");
            result.add("Sender and receivers both must be an existing real users on the system");
            result.add(false);
            return result;
        }

    }

    public void setUserDaoImpl(UserDao userDaoImpl) {
        this.userDaoImpl = userDaoImpl;
    }

    public void setUserTransferCoinsDAO(UserTransferCoinsDAO userTransferCoinsDAO) {
        this.userTransferCoinsDAO = userTransferCoinsDAO;
    }

    public void setEntityMapper(EntityMapper entityMapper) {
        this.entityMapper = entityMapper;
    }

    @Override
    public String generateRandomPassword() {
        String letters = "abcdefghjkmnpqrstuvwxyzABCDEFGHJKMNPQRSTUVWXYZ123456789!@";
        String password = "";
        for (int i = 0; i < PASSWORD_LENGTH; i++) {
            int index = (int) (RANDOM.nextDouble() * letters.length());
            password += letters.substring(index, index + 1);
        }
        return password;
    }

    @Override
    public boolean updateUser(UserDTO userDto) {
        try {
            User user = entityMapper.mapUserDtoToUser(userDto);
            userDaoImpl.update(user);
            return true;
        } catch (Exception ex) {
            Logger.getLogger(UserServiceImpl.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
    }

    @Override
    public ArrayList<Object> registerUser(UserDTO userDto) {
        ArrayList resultList = new ArrayList();
        if (checkAddingUserValidity(userDto.getEmail(), userDto.getPhone())) {
            addUser(userDto);
            resultList.add(0, userDto);
            resultList.add(1, "User is added successfully");
            return resultList;
        } else {
            resultList.add(0, null);
            resultList.add(1, "email or phone is invalid");
            return resultList;
        }
    }

    private boolean checkAddingUserValidity(String email, String phone) {
        UserDTO mailUser = getUserByEmail(email);
        UserDTO phoneUser = getUserByPhone(phone);

        if (mailUser == null && phoneUser == null) {
            return true;
        } else {
            return false;
        }
    }
}
