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
public class DeviceCurrentlyConnectedDevicesPK implements Serializable {

    @Basic(optional = false)
    @NotNull
    @Column(name = "host_device_id")
    private int hostDeviceId;
    @Basic(optional = false)
    @NotNull
    @Column(name = "guest_device_id")
    private int guestDeviceId;

    public DeviceCurrentlyConnectedDevicesPK() {
    }

    public DeviceCurrentlyConnectedDevicesPK(int hostDeviceId, int guestDeviceId) {
        this.hostDeviceId = hostDeviceId;
        this.guestDeviceId = guestDeviceId;
    }

    public int getHostDeviceId() {
        return hostDeviceId;
    }

    public void setHostDeviceId(int hostDeviceId) {
        this.hostDeviceId = hostDeviceId;
    }

    public int getGuestDeviceId() {
        return guestDeviceId;
    }

    public void setGuestDeviceId(int guestDeviceId) {
        this.guestDeviceId = guestDeviceId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (int) hostDeviceId;
        hash += (int) guestDeviceId;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof DeviceCurrentlyConnectedDevicesPK)) {
            return false;
        }
        DeviceCurrentlyConnectedDevicesPK other = (DeviceCurrentlyConnectedDevicesPK) object;
        if (this.hostDeviceId != other.hostDeviceId) {
            return false;
        }
        if (this.guestDeviceId != other.guestDeviceId) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.haas.server.entity.DeviceCurrentlyConnectedDevicesPK[ hostDeviceId=" + hostDeviceId + ", guestDeviceId=" + guestDeviceId + " ]";
    }
    
}
