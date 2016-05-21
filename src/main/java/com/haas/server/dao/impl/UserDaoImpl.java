package com.haas.server.dao.impl;

import com.haas.server.dao.GenericHibernateDAO;
import com.haas.server.dao.interfaces.UserDao;
import com.haas.server.entity.User;
import org.hibernate.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
@Transactional
public class UserDaoImpl extends GenericHibernateDAO<User, String> implements UserDao {

    public UserDaoImpl() {
    }
    
    @Override
    public User getUserByEmail(String email) {
        Query query = getSession().createQuery("from User where email= :email");
        query.setParameter("email", email);
        User user = (User) query.uniqueResult();
        return user;
    } 

    @Override
    public User getUserByPhone(String phone) {
        Query query = getSession().createQuery("from User where phone= :phone");
        query.setParameter("phone", phone);
        User user = (User) query.uniqueResult();
        return user;
    }

}
