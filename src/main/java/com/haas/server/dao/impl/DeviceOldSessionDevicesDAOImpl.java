package com.haas.server.dao.impl;

import com.haas.server.dao.GenericHibernateDAO;
import com.haas.server.dao.interfaces.DeviceOldSessionDevicesDAO;
import com.haas.server.entity.Device;
import com.haas.server.entity.DeviceOldSessionDevices;
import com.haas.server.entity.key.DeviceOldSessionDevicesPK;
import java.util.List;
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
    public List<DeviceOldSessionDevices> findAllWhereHostDeviceIs(Device device) {
        Query query = getSession().createQuery("from DeviceOldSessionDevices where device1= :device");
        query.setParameter("device", device);
        return query.list();

    }

    @Override
    public List<DeviceOldSessionDevices> findAllWhereGuestDeviceIs(Device device) {
        Query query = getSession().createQuery("from DeviceOldSessionDevices where device= :device");
        query.setParameter("device", device);
        return query.list();
    }

}
