/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.haas.server.entity.key;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.validation.constraints.NotNull;

/**
 *
 * @author Shall
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

    public UserUsesDevicePK() {
    }

    public UserUsesDevicePK(int deviceId, int userId) {
        this.deviceId = deviceId;
        this.userId = userId;
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

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (int) deviceId;
        hash += (int) userId;
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
        return true;
    }

    @Override
    public String toString() {
        return "com.haas.server.entity.UserUsesDevicePK[ deviceId=" + deviceId + ", userId=" + userId + " ]";
    }
    
}
