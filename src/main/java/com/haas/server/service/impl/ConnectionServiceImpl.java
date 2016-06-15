package com.haas.server.service.impl;

import com.haas.server.dao.interfaces.DeviceCurrentlyConnectedDevicesDAO;
import com.haas.server.dao.interfaces.DeviceDAO;
import com.haas.server.dao.interfaces.DeviceOldSessionDevicesDAO;
import com.haas.server.dao.interfaces.UserUsesDevicesDAO;
import com.haas.server.entity.DeviceCurrentlyConnectedDevices;
import com.haas.server.entity.DeviceInfo;
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
    @Autowired
    DeviceDAO deviceDAO;

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

    @Override
    public long getTotalNumberOfConnections() {
        long connectionsNumber = deviceOldSessionDevicesDAO.getTotalNumberOfConnections();
        return connectionsNumber;
    }

    @Override
    public double getTotalNumberOfMegabytes() {
        double totalMegabytes = deviceOldSessionDevicesDAO.getTotalNumberOfMegabytes();
        return totalMegabytes;
    }

    @Override
    public String getDeviceGuestsCountAndTotalMB(String serialNumber) {
        List<Object> result = new ArrayList<>();
        System.out.println("@@@@serial@@@@          " + serialNumber);
        DeviceInfo device = deviceDAO.getDeviceBySerialNumber(serialNumber);
        System.out.println("@@@ Device is:@@@     "+ device.getSerialNumber() +"      id=    "+ device.getDeviceId() );
        List<DeviceCurrentlyConnectedDevices> list = deviceCurrentlyConnectedDevicesDAO.findAllWhereHostDeviceIs(device);
        result.add(list.size());
        double totalMegas = 0;
        for (DeviceCurrentlyConnectedDevices connection : list) {
            totalMegas += connection.getConsumedMb();
        }
        result.add(totalMegas);
        System.out.println("@@@@@The List Device @@@@@      "+  list.size() + "     @@@  The Total Mega @@@@      "+ totalMegas);
        String resultSTR = list.size() + "," + totalMegas ;
        return resultSTR;
    }
    
//    @Override
//    public List<Object> getDeviceGuestsCountAndTotalMB(String serialNumber) {
//        List<Object> result = new ArrayList<>();
//
//        DeviceInfo device = deviceDAO.getDeviceBySerialNumber(serialNumber);
//        List<DeviceOldSessionDevices> list = deviceOldSessionDevicesDAO.findAllWhereHostDeviceIs(device);
//        result.add(list.size());
//        double totalMegas = 0;
//        for (DeviceOldSessionDevices connection : list) {
//            totalMegas += connection.getConsumedMb();
//        }
//        result.add(totalMegas);
//        System.out.println("@@@@@The List Device @@@@@      "+  list.size() + "     @@@  The Total Mega @@@@      "+ totalMegas);
//        return result;
//    }
    
}
