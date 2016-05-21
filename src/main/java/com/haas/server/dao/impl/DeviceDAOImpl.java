package com.haas.server.dao.impl;

import com.haas.server.dao.GenericHibernateDAO;
import com.haas.server.dao.interfaces.DeviceDAO;
import com.haas.server.entity.Device;
import org.hibernate.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author Shall
 */
@Repository
@Transactional
public class DeviceDAOImpl extends GenericHibernateDAO<Device, String> implements DeviceDAO {

    @Override
    public Device getDeviceBySerialNumber(String serialNumber) {
        Query query = getSession().createQuery("from Device where serial_number= :serialNumber");
        query.setParameter("serialNumber", serialNumber);
        Device device = (Device) query.uniqueResult();
        return device;
    }

}
