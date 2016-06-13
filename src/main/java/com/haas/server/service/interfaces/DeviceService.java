package com.haas.server.service.interfaces;

import com.haas.server.entity.UserUsesDevice;
import commons.dto.UserDTO;
import java.util.List;

/**
 *
 * @author Aya M. Ashraf
 */
public interface DeviceService {

    public boolean linkDevice(String email, String serialNumber);

    public boolean toKeepAlive(String hostSerial, String geustSerial, double consumedMB, long timeStamp, int updatedVersion, String status, String guestEmail, double silverCoins, double goldenCoins);

    public boolean trackingHostCoins(String hostEmail, double silverCoins, double goldenCoins);

    public List<UserUsesDevice> getUserDevices(UserDTO user);

    public long getTotalNumberOfSharedDevices();

}
