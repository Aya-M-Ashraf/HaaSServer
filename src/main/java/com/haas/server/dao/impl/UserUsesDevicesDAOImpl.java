package com.haas.server.dao.impl;

import com.haas.server.dao.GenericHibernateDAO;
import com.haas.server.dao.interfaces.UserUsesDevicesDAO;
import com.haas.server.entity.UserUsesDevice;
import com.haas.server.entity.key.UserUsesDevicePK;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author Shall
 */
@Repository
@Transactional
public class UserUsesDevicesDAOImpl extends GenericHibernateDAO<UserUsesDevice, UserUsesDevicePK> implements UserUsesDevicesDAO {

}
