package com.haas.server.dao.impl;

import com.haas.server.dao.GenericHibernateDAO;
import com.haas.server.dao.interfaces.UserUsesDevicesDAO;
import com.haas.server.entity.UserUsesDevice;
//import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author Shall
 */
@Repository
@Transactional
//@ComponentScan
public class UserUsesDevicesDAOImpl extends GenericHibernateDAO<UserUsesDevice, String> implements UserUsesDevicesDAO {

}
