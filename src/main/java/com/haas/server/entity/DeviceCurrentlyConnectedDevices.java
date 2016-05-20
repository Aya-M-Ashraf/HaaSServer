package com.haas.server.entity;

import com.haas.server.entity.key.DeviceCurrentlyConnectedDevicesPK;
import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
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
@Table(name = "device_currently_connected_devices")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "DeviceCurrentlyConnectedDevices.findAll", query = "SELECT d FROM DeviceCurrentlyConnectedDevices d"),
    @NamedQuery(name = "DeviceCurrentlyConnectedDevices.findByHostDeviceId", query = "SELECT d FROM DeviceCurrentlyConnectedDevices d WHERE d.deviceCurrentlyConnectedDevicesPK.hostDeviceId = :hostDeviceId"),
    @NamedQuery(name = "DeviceCurrentlyConnectedDevices.findByGuestDeviceId", query = "SELECT d FROM DeviceCurrentlyConnectedDevices d WHERE d.deviceCurrentlyConnectedDevicesPK.guestDeviceId = :guestDeviceId"),
    @NamedQuery(name = "DeviceCurrentlyConnectedDevices.findByStartTimestamp", query = "SELECT d FROM DeviceCurrentlyConnectedDevices d WHERE d.startTimestamp = :startTimestamp"),
    @NamedQuery(name = "DeviceCurrentlyConnectedDevices.findByUpdateVer", query = "SELECT d FROM DeviceCurrentlyConnectedDevices d WHERE d.updateVer = :updateVer"),
    @NamedQuery(name = "DeviceCurrentlyConnectedDevices.findByConsumedMb", query = "SELECT d FROM DeviceCurrentlyConnectedDevices d WHERE d.consumedMb = :consumedMb")})
public class DeviceCurrentlyConnectedDevices implements Serializable {

    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected DeviceCurrentlyConnectedDevicesPK deviceCurrentlyConnectedDevicesPK;
    @Basic(optional = false)
    @NotNull
    @Column(name = "start_timestamp")
    @Temporal(TemporalType.TIMESTAMP)
    private Date startTimestamp;
    @Basic(optional = false)
    @NotNull
    @Column(name = "update_ver")
    private int updateVer;
    @Basic(optional = false)
    @NotNull
    @Column(name = "consumed_mb")
    private double consumedMb;

    public DeviceCurrentlyConnectedDevices() {
    }

    public DeviceCurrentlyConnectedDevices(DeviceCurrentlyConnectedDevicesPK deviceCurrentlyConnectedDevicesPK) {
        this.deviceCurrentlyConnectedDevicesPK = deviceCurrentlyConnectedDevicesPK;
    }

    public DeviceCurrentlyConnectedDevices(DeviceCurrentlyConnectedDevicesPK deviceCurrentlyConnectedDevicesPK, Date startTimestamp, int updateVer, double consumedMb) {
        this.deviceCurrentlyConnectedDevicesPK = deviceCurrentlyConnectedDevicesPK;
        this.startTimestamp = startTimestamp;
        this.updateVer = updateVer;
        this.consumedMb = consumedMb;
    }

    public DeviceCurrentlyConnectedDevices(int hostDeviceId, int guestDeviceId) {
        this.deviceCurrentlyConnectedDevicesPK = new DeviceCurrentlyConnectedDevicesPK(hostDeviceId, guestDeviceId);
    }

    public DeviceCurrentlyConnectedDevicesPK getDeviceCurrentlyConnectedDevicesPK() {
        return deviceCurrentlyConnectedDevicesPK;
    }

    public void setDeviceCurrentlyConnectedDevicesPK(DeviceCurrentlyConnectedDevicesPK deviceCurrentlyConnectedDevicesPK) {
        this.deviceCurrentlyConnectedDevicesPK = deviceCurrentlyConnectedDevicesPK;
    }

    public Date getStartTimestamp() {
        return startTimestamp;
    }

    public void setStartTimestamp(Date startTimestamp) {
        this.startTimestamp = startTimestamp;
    }

    public int getUpdateVer() {
        return updateVer;
    }

    public void setUpdateVer(int updateVer) {
        this.updateVer = updateVer;
    }

    public double getConsumedMb() {
        return consumedMb;
    }

    public void setConsumedMb(double consumedMb) {
        this.consumedMb = consumedMb;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (deviceCurrentlyConnectedDevicesPK != null ? deviceCurrentlyConnectedDevicesPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof DeviceCurrentlyConnectedDevices)) {
            return false;
        }
        DeviceCurrentlyConnectedDevices other = (DeviceCurrentlyConnectedDevices) object;
        if ((this.deviceCurrentlyConnectedDevicesPK == null && other.deviceCurrentlyConnectedDevicesPK != null) || (this.deviceCurrentlyConnectedDevicesPK != null && !this.deviceCurrentlyConnectedDevicesPK.equals(other.deviceCurrentlyConnectedDevicesPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entitiy.DeviceCurrentlyConnectedDevices[ deviceCurrentlyConnectedDevicesPK=" + deviceCurrentlyConnectedDevicesPK + " ]";
    }
    
}
