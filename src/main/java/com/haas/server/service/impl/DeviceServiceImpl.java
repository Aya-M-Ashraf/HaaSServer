package com.haas.server.service.impl;

import com.haas.server.dao.interfaces.DeviceCurrentlyConnectedDevicesDAO;
import com.haas.server.dao.interfaces.DeviceDAO;
import com.haas.server.dao.interfaces.DeviceOldSessionDevicesDAO;
import com.haas.server.dao.interfaces.UserDao;
import com.haas.server.dao.interfaces.UserUsesDevicesDAO;
import com.haas.server.entity.Device;
import com.haas.server.entity.DeviceCurrentlyConnectedDevices;
import com.haas.server.entity.DeviceOldSessionDevices;
import com.haas.server.entity.User;
import com.haas.server.entity.UserUsesDevice;
import com.haas.server.entity.key.DeviceCurrentlyConnectedDevicesPK;
import com.haas.server.entity.key.DeviceOldSessionDevicesPK;
import com.haas.server.entity.key.UserUsesDevicePK;
import java.util.Date;
import com.haas.server.service.interfaces.DeviceService;
import com.haas.server.utils.EntityMapper;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author Aya M. Ashraf
 */
@Service
public class DeviceServiceImpl implements DeviceService {

    @Autowired
    DeviceDAO deviceDAO;
    @Autowired
    UserDao userDAO;
    @Autowired
    UserUsesDevicesDAO userUsesDevicesDAO;
    @Autowired
    EntityMapper mapper;
    @Autowired
    DeviceCurrentlyConnectedDevicesDAO deviceCurrentlyConnectedDevicesDAO;
    @Autowired
    DeviceOldSessionDevicesDAO deviceOldSessionDevicesDAO;

    public DeviceServiceImpl() {

    }

    @Override
    public boolean linkDevice(String email, String serialNumber) {
        try {
            Device device = deviceDAO.getDeviceBySerialNumber(serialNumber);
            User user = userDAO.getUserByEmail(email);
            if (user != null) {
                if (device != null) {
                    //this means that the device is registered and needs only to be linked
                    System.out.println("this means that the device is registered and needs only to be linked");
                    UserUsesDevice userUsesDevice = new UserUsesDevice(new UserUsesDevicePK(device.getDeviceId(), user.getUserId()), new Date());
                    userUsesDevicesDAO.makePersistent(userUsesDevice);
                    return true;
                } else {
                    //----------- No device is registered with this serial number
                    System.out.println("No device is registered with this serial number");
                    Device registerDevice = new Device(serialNumber);
                    deviceDAO.makePersistent(registerDevice);
                    Device addedDevice = deviceDAO.getDeviceBySerialNumber(serialNumber);
                    UserUsesDevice userUsesDevice = new UserUsesDevice(new UserUsesDevicePK(addedDevice.getDeviceId(), user.getUserId()), new Date());
                    userUsesDevicesDAO.makePersistent(userUsesDevice);
                    return true;
                }
            } else {
                //No such user in the system
                System.out.println("No such user in the system");
                return false;
            }
        } catch (Exception ex) {
            Logger.getLogger(DeviceServiceImpl.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
    }

    @Override
    @Transactional
    public boolean toKeepAlive(String hostSerial, String geustSerial, double consumedMB, Date timeStamp, int updatedVersion, String keepAliveStatus) {

        return false;
        
    }
}
