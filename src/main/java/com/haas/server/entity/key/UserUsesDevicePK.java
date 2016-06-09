package com.haas.server.entity.key;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;

/**
 *
 * @author Aya M. Ashraf
 */
@Embeddable
public class UserUsesDevicePK implements Serializable {

    @Basic(optional = false)
    @NotNull
    @Column(name = "device_id")
    private int deviceId;
    @Basic(optional = false)
    @NotNull
    @Column(name = "user_id")
    private int userId;
    @Basic(optional = false)
    @NotNull
    @Column(name = "start_using_timestamp")
    @Temporal(TemporalType.TIMESTAMP)
    private Date startUsingTimestamp;

    public UserUsesDevicePK() {
    }

    public UserUsesDevicePK(int deviceId, int userId, Date startUsingTimestamp) {
        this.deviceId = deviceId;
        this.userId = userId;
        this.startUsingTimestamp = startUsingTimestamp;
    }

    public int getDeviceId() {
        return deviceId;
    }

    public void setDeviceId(int deviceId) {
        this.deviceId = deviceId;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public Date getStartUsingTimestamp() {
        return startUsingTimestamp;
    }

    public void setStartUsingTimestamp(Date startUsingTimestamp) {
        this.startUsingTimestamp = startUsingTimestamp;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (int) deviceId;
        hash += (int) userId;
        hash += (startUsingTimestamp != null ? startUsingTimestamp.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof UserUsesDevicePK)) {
            return false;
        }
        UserUsesDevicePK other = (UserUsesDevicePK) object;
        if (this.deviceId != other.deviceId) {
            return false;
        }
        if (this.userId != other.userId) {
            return false;
        }
        if ((this.startUsingTimestamp == null && other.startUsingTimestamp != null) || (this.startUsingTimestamp != null && !this.startUsingTimestamp.equals(other.startUsingTimestamp))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.haas.server.entity.UserUsesDevicePK[ deviceId=" + deviceId + ", userId=" + userId + ", startUsingTimestamp=" + startUsingTimestamp + " ]";
    }
    
}
