package com.haas.server.dao.impl;

import com.haas.server.dao.GenericHibernateDAO;
import com.haas.server.dao.interfaces.DeviceOldSessionDevicesDAO;
import com.haas.server.entity.DeviceOldSessionDevices;
import com.haas.server.entity.key.DeviceOldSessionDevicesPK;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author Hossam
 */
@Repository
@Transactional
@ComponentScan
public class DeviceOldSessionDevicesDAOImpl extends GenericHibernateDAO<DeviceOldSessionDevices, DeviceOldSessionDevicesPK> implements DeviceOldSessionDevicesDAO{
    
}
