package com.haas.server.service.impl;

import com.haas.server.dao.interfaces.DeviceCurrentlyConnectedDevicesDAO;
import com.haas.server.dao.interfaces.DeviceDAO;
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
import org.springframework.beans.factory.annotation.Autowired;

/**
 *
 * @author Aya M. Ashraf
 */
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

    public DeviceServiceImpl() {

    }

    @Override
    public boolean linkDevice(String email, String serialNumber) {

        Device device = deviceDAO.getDeviceBySerialNumber(serialNumber);
        User user = userDAO.getUserByEmail(email);
        if (user != null) {
            if (device != null) { //this means that the device is registered and needs only to be linked
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

    }

    @Override
    public boolean toKeepAlive(String hostSerial, String geustSerial, double consumedMB, Date timeStamp, int updatedVersion, String keepAliveStatus) {

        DeviceCurrentlyConnectedDevices deviceCurrentlyConnectedDevices = null;
        DeviceOldSessionDevices deviceOldSessionDevices;
        Device hostDevice = deviceDAO.getDeviceBySerialNumber(hostSerial);
        Device guestDevice = deviceDAO.getDeviceBySerialNumber(geustSerial);
        boolean success = false;

        if (hostDevice != null && guestDevice != null) {
            switch (keepAliveStatus) {
                case "initiate": {
                    deviceCurrentlyConnectedDevices = new DeviceCurrentlyConnectedDevices(new DeviceCurrentlyConnectedDevicesPK(hostDevice.getDeviceId(), guestDevice.getDeviceId()), timeStamp, updatedVersion, consumedMB);
                    deviceCurrentlyConnectedDevicesDAO.makePersistent(deviceCurrentlyConnectedDevices);
                    success = true;
                    break;
                }

                case "run": {
                    deviceCurrentlyConnectedDevices = deviceCurrentlyConnectedDevicesDAO.findById(new DeviceCurrentlyConnectedDevicesPK(hostDevice.getDeviceId(), guestDevice.getDeviceId()));
                    deviceCurrentlyConnectedDevices.setConsumedMb(consumedMB);
                    deviceCurrentlyConnectedDevices.setUpdateVer(updatedVersion);
                    deviceCurrentlyConnectedDevicesDAO.update(deviceCurrentlyConnectedDevices);
                    success = true;
                    break;
                }

                case "end": {
                    deviceOldSessionDevices = new DeviceOldSessionDevices(new DeviceOldSessionDevicesPK(hostDevice.getDeviceId(), guestDevice.getDeviceId(), deviceCurrentlyConnectedDevices.getStartTimestamp()), timeStamp, consumedMB);
                    success = true;
                    break;
                }
            }
        } else {
            success = false;
        }
        return success;
    }

}
