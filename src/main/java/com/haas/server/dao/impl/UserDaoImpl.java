package com.haas.server.dao.impl;

import com.haas.server.dao.GenericHibernateDAO;
import com.haas.server.dao.interfaces.UserDao;
import com.haas.server.entity.UserInfo;
import org.hibernate.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
@Transactional
public class UserDaoImpl extends GenericHibernateDAO<UserInfo, Integer> implements UserDao {

    public UserDaoImpl() {
    }
    
    @Override
    public UserInfo getUserByEmail(String email) {
        Query query = getSession().createQuery("from UserInfo where email= :email");
        query.setParameter("email", email);
        UserInfo user = (UserInfo) query.uniqueResult();
        return user;
    } 

    @Override
    public UserInfo getUserByPhone(String phone) {
        Query query = getSession().createQuery("from UserInfo where phone= :phone");
        query.setParameter("phone", phone);
        UserInfo user = (UserInfo) query.uniqueResult();
        return user;
    }

}
