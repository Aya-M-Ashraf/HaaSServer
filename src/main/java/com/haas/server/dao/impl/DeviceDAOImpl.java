package com.haas.server.dao.impl;

import com.haas.server.dao.GenericHibernateDAO;
import com.haas.server.dao.interfaces.DeviceDAO;
import com.haas.server.entity.DeviceInfo;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author Shall
 */
@Repository
@Transactional
public class DeviceDAOImpl extends GenericHibernateDAO<DeviceInfo, Integer> implements DeviceDAO {

    @Override
    public DeviceInfo getDeviceBySerialNumber(String serialNumber) {
//        Query query = getSession().createQuery("from DeviceInfo where serial_number= :serial").setParameter("serial", serialNumber);
//        DeviceInfo device = (DeviceInfo) query.uniqueResult();
        Criteria criteria = getSession().createCriteria(DeviceInfo.class);
        criteria.add(Restrictions.eq("serialNumber", serialNumber));
        return (DeviceInfo) criteria.uniqueResult();
    }

    @Override
    public long getTotalNumberOfDevices() {
        long allDevices = 0;
        try {
            allDevices = findAll().size();
            return allDevices;
        } catch (Exception ex) {
            Logger.getLogger(DeviceDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        return allDevices;
    }
}
