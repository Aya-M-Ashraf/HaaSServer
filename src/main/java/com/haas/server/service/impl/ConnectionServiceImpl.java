package com.haas.server.service.impl;

import com.haas.server.dao.interfaces.DeviceCurrentlyConnectedDevicesDAO;
import com.haas.server.dao.interfaces.DeviceOldSessionDevicesDAO;
import com.haas.server.dao.interfaces.UserDao;
import com.haas.server.dao.interfaces.UserUsesDevicesDAO;
import com.haas.server.entity.DeviceOldSessionDevices;
import com.haas.server.entity.UserUsesDevice;
import com.haas.server.service.interfaces.ConnectionService;
import commons.dto.UserDTO;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author Aya M. Ashraf
 */
@Service
public class ConnectionServiceImpl implements ConnectionService {

    @Autowired
    DeviceCurrentlyConnectedDevicesDAO deviceCurrentlyConnectedDevicesDAO;
    @Autowired
    DeviceOldSessionDevicesDAO deviceOldSessionDevicesDAO;
    @Autowired
    UserUsesDevicesDAO userUsesDevicesDAOImpl;


    @Override
    public List<List<DeviceOldSessionDevices>> getPastHostConnections(UserDTO user) {

        List<List<DeviceOldSessionDevices>> hostConnections = new ArrayList<>();
        List<UserUsesDevice> userUsesDevices = userUsesDevicesDAOImpl.findAllWhereUserIs(user.getUserId());

        for (UserUsesDevice userUsesDevice : userUsesDevices) {
            hostConnections.add(deviceOldSessionDevicesDAO.findAllWhereHostDeviceIs(userUsesDevice.getDevice()));
        }
        return hostConnections;
    }

    @Override
    public List<List<DeviceOldSessionDevices>> getPastGuestConnections(UserDTO user) {

        List<List<DeviceOldSessionDevices>> guestConnections = new ArrayList<>();
        List<UserUsesDevice> userUsesDevices = userUsesDevicesDAOImpl.findAllWhereUserIs(user.getUserId());

        for (UserUsesDevice userUsesDevice : userUsesDevices) {
            guestConnections.add(deviceOldSessionDevicesDAO.findAllWhereGuestDeviceIs(userUsesDevice.getDevice()));
        }
        return guestConnections;
    }

}
