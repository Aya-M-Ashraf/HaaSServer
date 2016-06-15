package com.haas.server.service.interfaces;

import com.haas.server.entity.DeviceOldSessionDevices;
import commons.dto.UserDTO;
import java.util.List;

/**
 *
 * @author Aya M. Ashraf
 */
public interface ConnectionService {

    public List<List<DeviceOldSessionDevices>> getPastHostConnections(UserDTO user);

    public List<List<DeviceOldSessionDevices>> getPastGuestConnections(UserDTO user);

    public long getTotalNumberOfConnections();

    public double getTotalNumberOfMegabytes();

    public List<Object> getDeviceGuestsCountAndTotalMB(String serialNumber);

}
