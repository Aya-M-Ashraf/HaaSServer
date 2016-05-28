package com.haas.server.entity;

import java.io.Serializable;
import java.util.Collection;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Aya M. Ashraf
 */
@Entity
@Table(name = "device_info")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Device.findAll", query = "SELECT d FROM Device d"),
    @NamedQuery(name = "Device.findByDeviceId", query = "SELECT d FROM Device d WHERE d.deviceId = :deviceId"),
    @NamedQuery(name = "Device.findBySerialNumber", query = "SELECT d FROM Device d WHERE d.serialNumber = :serialNumber")})
public class Device implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "device_id")
    private Integer deviceId;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "serial_number")
    private String serialNumber;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "device")
    private Collection<UserUsesDevice> userUsesDeviceCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "device")
    private Collection<DeviceOldSessionDevices> deviceOldSessionDevicesCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "device1")
    private Collection<DeviceOldSessionDevices> deviceOldSessionDevicesCollection1;

    public Device() {
    }

    public Device(Integer deviceId) {
        this.deviceId = deviceId;
    }

    public Device(String serialNumber) {
        this.serialNumber = serialNumber;
    }
    
    public Device(Integer deviceId, String serialNumber) {
        this.deviceId = deviceId;
        this.serialNumber = serialNumber;
    }

    public Integer getDeviceId() {
        return deviceId;
    }

    public void setDeviceId(Integer deviceId) {
        this.deviceId = deviceId;
    }

    public String getSerialNumber() {
        return serialNumber;
    }

    public void setSerialNumber(String serialNumber) {
        this.serialNumber = serialNumber;
    }

    @XmlTransient
    public Collection<UserUsesDevice> getUserUsesDeviceCollection() {
        return userUsesDeviceCollection;
    }

    public void setUserUsesDeviceCollection(Collection<UserUsesDevice> userUsesDeviceCollection) {
        this.userUsesDeviceCollection = userUsesDeviceCollection;
    }

    @XmlTransient
    public Collection<DeviceOldSessionDevices> getDeviceOldSessionDevicesCollection() {
        return deviceOldSessionDevicesCollection;
    }

    public void setDeviceOldSessionDevicesCollection(Collection<DeviceOldSessionDevices> deviceOldSessionDevicesCollection) {
        this.deviceOldSessionDevicesCollection = deviceOldSessionDevicesCollection;
    }

    @XmlTransient
    public Collection<DeviceOldSessionDevices> getDeviceOldSessionDevicesCollection1() {
        return deviceOldSessionDevicesCollection1;
    }

    public void setDeviceOldSessionDevicesCollection1(Collection<DeviceOldSessionDevices> deviceOldSessionDevicesCollection1) {
        this.deviceOldSessionDevicesCollection1 = deviceOldSessionDevicesCollection1;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (deviceId != null ? deviceId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Device)) {
            return false;
        }
        Device other = (Device) object;
        if ((this.deviceId == null && other.deviceId != null) || (this.deviceId != null && !this.deviceId.equals(other.deviceId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entitiy.Device[ deviceId=" + deviceId + " ]";
    }
    
}
