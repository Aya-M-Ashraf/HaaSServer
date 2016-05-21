package com.haas.server.dao.interfaces;

import com.haas.server.entity.Device;

/**
 *
 * @author Shall
 */
public interface DeviceDAO extends GenericDAO<Device, Integer> {

    public Device getDeviceBySerialNumber(String serialNumber);
}
