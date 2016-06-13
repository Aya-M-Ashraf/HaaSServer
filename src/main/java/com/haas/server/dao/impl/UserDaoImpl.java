package com.haas.server.dao.impl;

import com.haas.server.dao.GenericHibernateDAO;
import com.haas.server.dao.interfaces.UserDao;
import com.haas.server.entity.UserInfo;
import java.util.logging.Level;
import java.util.logging.Logger;
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

    @Override
    public long getTotalNumberOfUsers() {
        long allUsers = 0;
        try {
            allUsers = findAll().size();
        } catch (Exception ex) {
            Logger.getLogger(UserDaoImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        return allUsers;
    }

    @Override
    public long getTotalNumberOfMaleUsers() {
        //Assuming that 0 value of the gender means male
        long maleUsers = (long) getSession().createQuery("From UserInfo user Where user.gender = 1").uniqueResult();
        return maleUsers;
    }

    @Override
    public long getTotalNumberOfFemaleUsers() {
        //Assuming that 1 value of the gender means female
        long femaleUsers = (long) getSession().createQuery("From UserInfo user Where user.gender = 1").uniqueResult();
        return femaleUsers;
    }

}
