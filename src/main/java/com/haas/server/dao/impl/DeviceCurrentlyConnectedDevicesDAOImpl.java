package com.haas.server.dao.impl;

import com.haas.server.dao.GenericHibernateDAO;
import com.haas.server.dao.interfaces.DeviceCurrentlyConnectedDevicesDAO;
import com.haas.server.entity.DeviceCurrentlyConnectedDevices;
import com.haas.server.entity.key.DeviceCurrentlyConnectedDevicesPK;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author Hossam
 */
@Repository
@Transactional
public class DeviceCurrentlyConnectedDevicesDAOImpl extends GenericHibernateDAO<DeviceCurrentlyConnectedDevices, DeviceCurrentlyConnectedDevicesPK> implements DeviceCurrentlyConnectedDevicesDAO{
    
}
