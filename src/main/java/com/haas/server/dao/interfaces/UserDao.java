package com.haas.server.dao.interfaces;


import com.haas.server.entity.UserInfo;


public interface UserDao extends GenericDAO<UserInfo, Integer> {
    public UserInfo getUserByEmail(String email);

    public UserInfo getUserByPhone(String phone);
}
