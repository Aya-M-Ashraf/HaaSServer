/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.haas.server.dao.interfaces;

import com.haas.server.entity.Device;

/**
 *
 * @author Shall
 */
public interface DeviceDAO extends GenericDAO<Device, String> {

    public Device getDeviceBySerialNumber(String serialNumber);
    
    

}
