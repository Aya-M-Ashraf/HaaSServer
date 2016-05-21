package com.haas.server.dao.interfaces;


import com.haas.server.entity.User;


public interface UserDao extends GenericDAO<User, Integer> {
    public User getUserByEmail(String email);

    public User getUserByPhone(String phone);
}
