package com.haas.server.dao.impl;

import com.haas.server.dao.GenericHibernateDAO;
import com.haas.server.dao.interfaces.UserUsesDevicesDAO;
import com.haas.server.entity.DeviceInfo;
import com.haas.server.entity.UserUsesDevice;
import com.haas.server.entity.key.UserUsesDevicePK;
import java.util.List;
import org.hibernate.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author Shall
 */
@Repository
@Transactional
public class UserUsesDevicesDAOImpl extends GenericHibernateDAO<UserUsesDevice, UserUsesDevicePK> implements UserUsesDevicesDAO {

    @Override
    public List<UserUsesDevice> findAllWhereUserIs(Integer userId) {
        Query query = getSession().createQuery("from UserUsesDevice where user.userId= :userId");
        query.setParameter("userId", userId);
        return query.list();
    }

    @Override
    public List<UserUsesDevice> findByDevice(DeviceInfo device) {
        Query query = getSession().createQuery("from UserUsesDevice where device= :device");
        query.setParameter("device", device);
        return query.list();
    }
}
