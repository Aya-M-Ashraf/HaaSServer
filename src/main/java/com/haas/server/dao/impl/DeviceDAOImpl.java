package com.haas.server.dao.impl;

import com.haas.server.dao.GenericHibernateDAO;
import com.haas.server.dao.interfaces.DeviceDAO;
import com.haas.server.entity.DeviceInfo;
import org.hibernate.Criteria;
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
        return (DeviceInfo)criteria.uniqueResult();
    }

}
