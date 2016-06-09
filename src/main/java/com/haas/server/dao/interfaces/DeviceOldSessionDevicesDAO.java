package com.haas.server.dao.interfaces;

import com.haas.server.entity.DeviceInfo;
import com.haas.server.entity.DeviceOldSessionDevices;
import com.haas.server.entity.key.DeviceOldSessionDevicesPK;
import java.util.List;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author Hossam
 */
@Repository
@Transactional
public interface DeviceOldSessionDevicesDAO extends GenericDAO<DeviceOldSessionDevices, DeviceOldSessionDevicesPK>{
   
    public List<DeviceOldSessionDevices> findAllWhereHostDeviceIs(DeviceInfo device);
    
    public List<DeviceOldSessionDevices> findAllWhereGuestDeviceIs(DeviceInfo device);
}
