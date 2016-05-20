package com.haas.server.entity;

import com.haas.server.entity.key.UserUsesDevicePK;
import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Aya M. Ashraf
 */
@Entity
@Table(name = "user_uses_device")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "UserUsesDevice.findAll", query = "SELECT u FROM UserUsesDevice u"),
    @NamedQuery(name = "UserUsesDevice.findByDeviceId", query = "SELECT u FROM UserUsesDevice u WHERE u.userUsesDevicePK.deviceId = :deviceId"),
    @NamedQuery(name = "UserUsesDevice.findByUserId", query = "SELECT u FROM UserUsesDevice u WHERE u.userUsesDevicePK.userId = :userId"),
    @NamedQuery(name = "UserUsesDevice.findByStartUsingTimestamp", query = "SELECT u FROM UserUsesDevice u WHERE u.startUsingTimestamp = :startUsingTimestamp"),
    @NamedQuery(name = "UserUsesDevice.findByEndUsingTimestamp", query = "SELECT u FROM UserUsesDevice u WHERE u.endUsingTimestamp = :endUsingTimestamp")})
public class UserUsesDevice implements Serializable {

    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected UserUsesDevicePK userUsesDevicePK;
    @Basic(optional = false)
    @NotNull
    @Column(name = "start_using_timestamp")
    @Temporal(TemporalType.TIMESTAMP)
    private Date startUsingTimestamp;
    @Column(name = "end_using_timestamp")
    @Temporal(TemporalType.TIMESTAMP)
    private Date endUsingTimestamp;
    @JoinColumn(name = "device_id", referencedColumnName = "device_id", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Device device;
    @JoinColumn(name = "user_id", referencedColumnName = "user_id", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private User user;

    public UserUsesDevice() {
    }

    public UserUsesDevice(UserUsesDevicePK userUsesDevicePK) {
        this.userUsesDevicePK = userUsesDevicePK;
    }

    public UserUsesDevice(UserUsesDevicePK userUsesDevicePK, Date startUsingTimestamp) {
        this.userUsesDevicePK = userUsesDevicePK;
        this.startUsingTimestamp = startUsingTimestamp;
    }

    public UserUsesDevice(int deviceId, int userId) {
        this.userUsesDevicePK = new UserUsesDevicePK(deviceId, userId);
    }

    public UserUsesDevicePK getUserUsesDevicePK() {
        return userUsesDevicePK;
    }

    public void setUserUsesDevicePK(UserUsesDevicePK userUsesDevicePK) {
        this.userUsesDevicePK = userUsesDevicePK;
    }

    public Date getStartUsingTimestamp() {
        return startUsingTimestamp;
    }

    public void setStartUsingTimestamp(Date startUsingTimestamp) {
        this.startUsingTimestamp = startUsingTimestamp;
    }

    public Date getEndUsingTimestamp() {
        return endUsingTimestamp;
    }

    public void setEndUsingTimestamp(Date endUsingTimestamp) {
        this.endUsingTimestamp = endUsingTimestamp;
    }

    public Device getDevice() {
        return device;
    }

    public void setDevice(Device device) {
        this.device = device;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (userUsesDevicePK != null ? userUsesDevicePK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof UserUsesDevice)) {
            return false;
        }
        UserUsesDevice other = (UserUsesDevice) object;
        if ((this.userUsesDevicePK == null && other.userUsesDevicePK != null) || (this.userUsesDevicePK != null && !this.userUsesDevicePK.equals(other.userUsesDevicePK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entitiy.UserUsesDevice[ userUsesDevicePK=" + userUsesDevicePK + " ]";
    }
    
}
