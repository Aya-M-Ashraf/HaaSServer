package com.haas.server.dao.impl;

import com.haas.server.dao.GenericHibernateDAO;
import com.haas.server.dao.interfaces.DeviceDAO;
import com.haas.server.entity.DeviceInfo;
import org.hibernate.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author Shall
 */
@Repository
@Transactional
public class DeviceDAOImpl extends GenericHibernateDAO<DeviceInfo, Integer> implements DeviceDAO {

    @Override
    public DeviceInfo getDeviceBySerialNumber(String serialNumber) {
        Query query = getSession().createQuery("from Device where serial_number= :serialNumber");
        query.setParameter("serialNumber", serialNumber);
        DeviceInfo device = (DeviceInfo) query.uniqueResult();
        return device;
    }

}
