package com.haas.server.dao.interfaces;

import com.haas.server.entity.DeviceInfo;

/**
 *
 * @author Shall
 */
public interface DeviceDAO extends GenericDAO<DeviceInfo, Integer> {

    public DeviceInfo getDeviceBySerialNumber(String serialNumber);
    public long getTotalNumberOfDevices();
}
