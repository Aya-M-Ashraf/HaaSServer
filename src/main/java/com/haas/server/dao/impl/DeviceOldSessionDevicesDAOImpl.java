package com.haas.server.dao.impl;

import com.haas.server.dao.GenericHibernateDAO;
import com.haas.server.dao.interfaces.DeviceOldSessionDevicesDAO;
import com.haas.server.entity.DeviceInfo;
import com.haas.server.entity.DeviceOldSessionDevices;
import com.haas.server.entity.key.DeviceOldSessionDevicesPK;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.hibernate.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author Hossam
 */
@Repository
@Transactional
public class DeviceOldSessionDevicesDAOImpl extends GenericHibernateDAO<DeviceOldSessionDevices, DeviceOldSessionDevicesPK> implements DeviceOldSessionDevicesDAO {

    @Override
    public List<DeviceOldSessionDevices> findAllWhereHostDeviceIs(DeviceInfo device) {
        Query query = getSession().createQuery("from DeviceOldSessionDevices where device1= :device");
        query.setParameter("device", device);
        return query.list();

    }

    @Override
    public List<DeviceOldSessionDevices> findAllWhereGuestDeviceIs(DeviceInfo device) {
        Query query = getSession().createQuery("from DeviceOldSessionDevices where device= :device");
        query.setParameter("device", device);
        return query.list();
    }

    @Override
    public long getTotalNumberOfConnections() {
        long allConnections = 0;
        try {
            allConnections = findAll().size();
        } catch (Exception ex) {
            Logger.getLogger(DeviceOldSessionDevicesDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        return allConnections;
    }

    @Override
    public double getTotalNumberOfMegabytes() {
        double totalMegabytes = 0;
        totalMegabytes = (Double) getSession().createQuery("SELECT count(consumedMb) FROM DeviceOldSessionDevices").uniqueResult();
        return totalMegabytes;
    }

}
