package com.haas.server.service.impl;

import com.haas.server.dao.interfaces.DeviceCurrentlyConnectedDevicesDAO;
import com.haas.server.dao.interfaces.DeviceDAO;
import com.haas.server.dao.interfaces.DeviceOldSessionDevicesDAO;
import com.haas.server.dao.interfaces.UserDao;
import com.haas.server.dao.interfaces.UserUsesDevicesDAO;
import com.haas.server.entity.DeviceInfo;
import com.haas.server.entity.DeviceCurrentlyConnectedDevices;
import com.haas.server.entity.DeviceOldSessionDevices;
import com.haas.server.entity.UserInfo;
import com.haas.server.entity.UserUsesDevice;
import com.haas.server.entity.key.DeviceCurrentlyConnectedDevicesPK;
import com.haas.server.entity.key.DeviceOldSessionDevicesPK;
import com.haas.server.entity.key.UserUsesDevicePK;
import java.util.Date;
import com.haas.server.service.interfaces.DeviceService;
import commons.dto.UserDTO;
import commons.ws.Constants;
import java.util.List;
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
    DeviceCurrentlyConnectedDevicesDAO deviceCurrentlyConnectedDevicesDAO;
    @Autowired
    DeviceOldSessionDevicesDAO deviceOldSessionDevicesDAO;

    public DeviceServiceImpl() {

    }

    @Override
    public boolean linkDevice(String email, String serialNumber) {
        try {
            DeviceInfo device = deviceDAO.getDeviceBySerialNumber(serialNumber);
            UserInfo user = userDAO.getUserByEmail(email);
            if (user != null) {
                if (device != null) {
                    //this means that the device is registered and needs only to be linked
                    System.out.println("this means that the device is registered and needs only to be linked");
                    UserUsesDevice userUsesDevice = new UserUsesDevice(new UserUsesDevicePK(device.getDeviceId(), user.getUserId(), new Date()));
                    userUsesDevicesDAO.makePersistent(userUsesDevice);
                    return true;
                } else {
                    //----------- No device is registered with this serial number
                    System.out.println("No device is registered with this serial number");
                    DeviceInfo registerDevice = new DeviceInfo(serialNumber);
                    deviceDAO.makePersistent(registerDevice);
                    DeviceInfo addedDevice = deviceDAO.getDeviceBySerialNumber(serialNumber);
                    UserUsesDevice userUsesDevice = new UserUsesDevice(new UserUsesDevicePK(addedDevice.getDeviceId(), user.getUserId(), new Date()));
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
    public boolean toKeepAlive(String hostSerial, String geustSerial, double consumedMB, long timeStamp, int updatedVersion, String keepAliveStatus, String guestEmail, double silverCoins, double goldenCoins) {

        try {
            DeviceCurrentlyConnectedDevices deviceCurrentlyConnectedDevices = null;
            DeviceOldSessionDevices deviceOldSessionDevices;
            DeviceInfo hostDevice = deviceDAO.getDeviceBySerialNumber(hostSerial);
            DeviceInfo guestDevice = deviceDAO.getDeviceBySerialNumber(geustSerial);
            UserInfo user = userDAO.getUserByEmail(guestEmail);;
            boolean success = false;

            if (hostDevice != null && guestDevice != null && user != null) {

                switch (keepAliveStatus) {

                    case Constants.INIT_STATUS: {
                        System.out.println("**** inside keep alive WS - INIT ");
                        System.out.println("EMAILLLLLL          " + guestEmail);
                        System.out.println("Date : " + new Date(timeStamp));

                        deviceCurrentlyConnectedDevices = new DeviceCurrentlyConnectedDevices(new DeviceCurrentlyConnectedDevicesPK(hostDevice.getDeviceId(), guestDevice.getDeviceId()), new Date(timeStamp), updatedVersion, consumedMB);
                        deviceCurrentlyConnectedDevicesDAO.makePersistent(deviceCurrentlyConnectedDevices);
                        // new in oldSession to keep track with each request
                        deviceOldSessionDevices = new DeviceOldSessionDevices(new DeviceOldSessionDevicesPK(hostDevice.getDeviceId(), guestDevice.getDeviceId(), deviceCurrentlyConnectedDevices.getStartTimestamp()), new Date(timeStamp), consumedMB);
                        deviceOldSessionDevicesDAO.makePersistent(deviceOldSessionDevices);

                        user.setSilverCoins(silverCoins);
                        user.setGoldenCoins(goldenCoins);
                        userDAO.update(user);

                        success = true;
                    }
                    break;

                    case Constants.RUN_STATUS: {
                        deviceCurrentlyConnectedDevices = deviceCurrentlyConnectedDevicesDAO.findById(new DeviceCurrentlyConnectedDevicesPK(hostDevice.getDeviceId(), guestDevice.getDeviceId()));
                        deviceCurrentlyConnectedDevices.setConsumedMb(consumedMB);
                        deviceCurrentlyConnectedDevices.setUpdateVer(updatedVersion);
                        deviceCurrentlyConnectedDevices = deviceCurrentlyConnectedDevicesDAO.update(deviceCurrentlyConnectedDevices);
                        System.out.println("**** inside keep alive WS - RUN ");
                        System.out.println("Date : " + new Date(timeStamp));

                        // new in oldSession to keep track with each request
                        deviceOldSessionDevices = deviceOldSessionDevicesDAO.findById(new DeviceOldSessionDevicesPK(hostDevice.getDeviceId(), guestDevice.getDeviceId(), deviceCurrentlyConnectedDevices.getStartTimestamp()));
                        deviceOldSessionDevices.setConsumedMb(consumedMB);
                        deviceOldSessionDevices.setEndTimestamp(new Date(timeStamp));
                        deviceOldSessionDevices = deviceOldSessionDevicesDAO.update(deviceOldSessionDevices);

                        user.setSilverCoins(silverCoins);
                        user.setGoldenCoins(goldenCoins);
                        userDAO.update(user);

                        success = true;
                    }
                    break;

                    case Constants.END_STATUS: {
                        System.out.println("**** inside keep alive WS - END ");
                        System.out.println("Date : " + new Date(timeStamp));
                        deviceCurrentlyConnectedDevices = deviceCurrentlyConnectedDevicesDAO.findById(new DeviceCurrentlyConnectedDevicesPK(hostDevice.getDeviceId(), guestDevice.getDeviceId()));
                        deviceOldSessionDevices = deviceOldSessionDevicesDAO.findById(new DeviceOldSessionDevicesPK(hostDevice.getDeviceId(), guestDevice.getDeviceId(), deviceCurrentlyConnectedDevices.getStartTimestamp()));
                        deviceOldSessionDevices.setConsumedMb(consumedMB);
                        deviceOldSessionDevices.setEndTimestamp(new Date(timeStamp));
                        deviceOldSessionDevicesDAO.update(deviceOldSessionDevices);
                        deviceCurrentlyConnectedDevicesDAO.makeTransient(deviceCurrentlyConnectedDevices);

                        user.setSilverCoins(silverCoins);
                        user.setGoldenCoins(goldenCoins);
                        userDAO.update(user);

                        success = true;
                    }
                    break;

                    default:
                        success = false;
                }
            } else {
                success = false;
            }
            return success;
        } catch (Exception ex) {
            Logger.getLogger(DeviceServiceImpl.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
    }

    @Override
    public boolean trackingHostCoins(String hostEmail, double silverCoins, double goldenCoins) {

        System.out.println("@@@@@@@ Inside coins of host @@@@@@");
        boolean success = false;
        UserInfo user;

        user = userDAO.getUserByEmail(hostEmail);
        if (user == null) {
            success = false;
        } else {
            try {
                user.setSilverCoins(silverCoins);
                user.setGoldenCoins(goldenCoins);
                userDAO.update(user);
                success = true;
            } catch (Exception ex) {
                Logger.getLogger(DeviceServiceImpl.class.getName()).log(Level.SEVERE, null, ex);
                success = false;
            }
        }
        return success;
    }

    @Override
    public List<UserUsesDevice> getUserDevices(UserDTO user) {
        return userUsesDevicesDAO.findAllWhereUserIs(user.getUserId());
    }
}
