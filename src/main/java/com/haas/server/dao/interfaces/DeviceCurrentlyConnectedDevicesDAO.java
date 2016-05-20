package com.haas.server.dao.interfaces;

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
public interface DeviceCurrentlyConnectedDevicesDAO extends GenericDAO<DeviceCurrentlyConnectedDevices, DeviceCurrentlyConnectedDevicesPK>{
    
}
