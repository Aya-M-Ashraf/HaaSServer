package com.haas.server.service.interfaces;

import java.util.Date;

/**
 *
 * @author Aya M. Ashraf
 */
public interface DeviceService {
    
    public boolean linkDevice(String email,String serialNumber);
    public boolean toKeepAlive(String hostSerial, String geustSerial, double consumedMB, Date timeStamp, int updatedVersion, String status);
    
}
