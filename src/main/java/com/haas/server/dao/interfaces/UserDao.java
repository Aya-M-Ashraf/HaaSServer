package com.haas.server.dao.interfaces;

import com.haas.server.entity.UserInfo;
import java.util.List;

public interface UserDao extends GenericDAO<UserInfo, Integer> {

    public UserInfo getUserByEmail(String email);

    public UserInfo getUserByPhone(String phone);
    
    public List<UserInfo> getUsersByCountry(String city);

    public long getTotalNumberOfUsers();

    public long getTotalNumberOfMaleUsers();

    public long getTotalNumberOfFemaleUsers();
}
