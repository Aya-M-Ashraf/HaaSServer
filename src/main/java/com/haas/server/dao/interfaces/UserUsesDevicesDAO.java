package com.haas.server.dao.interfaces;

import com.haas.server.entity.DeviceInfo;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import com.haas.server.entity.UserUsesDevice;
import com.haas.server.entity.key.UserUsesDevicePK;
import java.util.List;

/**
 *
 * @author Shall
 */
@Repository
@Transactional
public interface UserUsesDevicesDAO extends GenericDAO<UserUsesDevice, UserUsesDevicePK> {

    public List<UserUsesDevice> findAllWhereUserIs(Integer userId);

    public List<UserUsesDevice> findByDevice(DeviceInfo device);

}
