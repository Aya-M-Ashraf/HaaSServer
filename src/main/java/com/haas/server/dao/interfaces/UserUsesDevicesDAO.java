package com.haas.server.dao.interfaces;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import com.haas.server.entity.UserUsesDevice;
import com.haas.server.entity.key.UserUsesDevicePK;

/**
 *
 * @author Shall
 */
@Repository
@Transactional
public interface UserUsesDevicesDAO extends GenericDAO<UserUsesDevice, UserUsesDevicePK> {

}
