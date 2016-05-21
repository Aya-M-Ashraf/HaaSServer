package com.haas.server.dao.impl;

import com.haas.server.dao.GenericHibernateDAO;
import com.haas.server.dao.interfaces.UserTransferCoinsDAO;
import com.haas.server.entity.UserTransferCoinsUser;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author Shall
 */
@Repository
@Transactional
public class UserTransferCoinsDAOImpl extends GenericHibernateDAO<UserTransferCoinsUser, String> implements UserTransferCoinsDAO{
    
}
