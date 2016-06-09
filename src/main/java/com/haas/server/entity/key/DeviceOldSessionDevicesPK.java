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
public class DeviceOldSessionDevicesPK implements Serializable {

    @Basic(optional = false)
    @NotNull
    @Column(name = "host_device_id")
    private int hostDeviceId;
    @Basic(optional = false)
    @NotNull
    @Column(name = "guest_device_id")
    private int guestDeviceId;
    @Basic(optional = false)
    @NotNull
    @Column(name = "start_timestamp")
    @Temporal(TemporalType.TIMESTAMP)
    private Date startTimestamp;

    public DeviceOldSessionDevicesPK() {
    }

    public DeviceOldSessionDevicesPK(int hostDeviceId, int guestDeviceId, Date startTimestamp) {
        this.hostDeviceId = hostDeviceId;
        this.guestDeviceId = guestDeviceId;
        this.startTimestamp = startTimestamp;
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

    public Date getStartTimestamp() {
        return startTimestamp;
    }

    public void setStartTimestamp(Date startTimestamp) {
        this.startTimestamp = startTimestamp;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (int) hostDeviceId;
        hash += (int) guestDeviceId;
        hash += (startTimestamp != null ? startTimestamp.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof DeviceOldSessionDevicesPK)) {
            return false;
        }
        DeviceOldSessionDevicesPK other = (DeviceOldSessionDevicesPK) object;
        if (this.hostDeviceId != other.hostDeviceId) {
            return false;
        }
        if (this.guestDeviceId != other.guestDeviceId) {
            return false;
        }
        if ((this.startTimestamp == null && other.startTimestamp != null) || (this.startTimestamp != null && !this.startTimestamp.equals(other.startTimestamp))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.haas.server.entity.DeviceOldSessionDevicesPK[ hostDeviceId=" + hostDeviceId + ", guestDeviceId=" + guestDeviceId + ", startTimestamp=" + startTimestamp + " ]";
    }
    
}
