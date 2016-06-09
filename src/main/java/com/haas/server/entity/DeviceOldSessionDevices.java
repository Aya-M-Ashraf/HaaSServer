package com.haas.server.entity;

import com.haas.server.entity.key.DeviceOldSessionDevicesPK;
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
@Table(name = "device_old_session_devices")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "DeviceOldSessionDevices.findAll", query = "SELECT d FROM DeviceOldSessionDevices d"),
    @NamedQuery(name = "DeviceOldSessionDevices.findByHostDeviceId", query = "SELECT d FROM DeviceOldSessionDevices d WHERE d.deviceOldSessionDevicesPK.hostDeviceId = :hostDeviceId"),
    @NamedQuery(name = "DeviceOldSessionDevices.findByGuestDeviceId", query = "SELECT d FROM DeviceOldSessionDevices d WHERE d.deviceOldSessionDevicesPK.guestDeviceId = :guestDeviceId"),
    @NamedQuery(name = "DeviceOldSessionDevices.findByStartTimestamp", query = "SELECT d FROM DeviceOldSessionDevices d WHERE d.deviceOldSessionDevicesPK.startTimestamp = :startTimestamp"),
    @NamedQuery(name = "DeviceOldSessionDevices.findByEndTimestamp", query = "SELECT d FROM DeviceOldSessionDevices d WHERE d.endTimestamp = :endTimestamp"),
    @NamedQuery(name = "DeviceOldSessionDevices.findByConsumedMb", query = "SELECT d FROM DeviceOldSessionDevices d WHERE d.consumedMb = :consumedMb")})
public class DeviceOldSessionDevices implements Serializable {

    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected DeviceOldSessionDevicesPK deviceOldSessionDevicesPK;
    @Column(name = "end_timestamp")
    @Temporal(TemporalType.TIMESTAMP)
    private Date endTimestamp;
    @Basic(optional = false)
    @NotNull
    @Column(name = "consumed_mb")
    private double consumedMb;
    @JoinColumn(name = "guest_device_id", referencedColumnName = "device_id", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private DeviceInfo device;
    @JoinColumn(name = "host_device_id", referencedColumnName = "device_id", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private DeviceInfo device1;

    public DeviceOldSessionDevices() {
    }

    public DeviceOldSessionDevices(DeviceOldSessionDevicesPK deviceOldSessionDevicesPK) {
        this.deviceOldSessionDevicesPK = deviceOldSessionDevicesPK;
    }

    public DeviceOldSessionDevices(DeviceOldSessionDevicesPK deviceOldSessionDevicesPK, double consumedMb) {
        this.deviceOldSessionDevicesPK = deviceOldSessionDevicesPK;
        this.consumedMb = consumedMb;
    }

    public DeviceOldSessionDevices(int hostDeviceId, int guestDeviceId, Date startTimestamp) {
        this.deviceOldSessionDevicesPK = new DeviceOldSessionDevicesPK(hostDeviceId, guestDeviceId, startTimestamp);
    }

     public DeviceOldSessionDevices(DeviceOldSessionDevicesPK deviceOldSessionDevicesPK, Date endTimestamp, double consumedMb) {
        this.deviceOldSessionDevicesPK = deviceOldSessionDevicesPK;
        this.endTimestamp = endTimestamp;
        this.consumedMb = consumedMb;
    }
    
    public DeviceOldSessionDevicesPK getDeviceOldSessionDevicesPK() {
        return deviceOldSessionDevicesPK;
    }

    public void setDeviceOldSessionDevicesPK(DeviceOldSessionDevicesPK deviceOldSessionDevicesPK) {
        this.deviceOldSessionDevicesPK = deviceOldSessionDevicesPK;
    }

    public Date getEndTimestamp() {
        return endTimestamp;
    }

    public void setEndTimestamp(Date endTimestamp) {
        this.endTimestamp = endTimestamp;
    }

    public double getConsumedMb() {
        return consumedMb;
    }

    public void setConsumedMb(double consumedMb) {
        this.consumedMb = consumedMb;
    }

    public DeviceInfo getDevice() {
        return device;
    }

    public void setDevice(DeviceInfo device) {
        this.device = device;
    }

    public DeviceInfo getDevice1() {
        return device1;
    }

    public void setDevice1(DeviceInfo device1) {
        this.device1 = device1;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (deviceOldSessionDevicesPK != null ? deviceOldSessionDevicesPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof DeviceOldSessionDevices)) {
            return false;
        }
        DeviceOldSessionDevices other = (DeviceOldSessionDevices) object;
        if ((this.deviceOldSessionDevicesPK == null && other.deviceOldSessionDevicesPK != null) || (this.deviceOldSessionDevicesPK != null && !this.deviceOldSessionDevicesPK.equals(other.deviceOldSessionDevicesPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.haas.server.entity.DeviceOldSessionDevices[ deviceOldSessionDevicesPK=" + deviceOldSessionDevicesPK + " ]";
    }
    
}
