package commons.dto;


/**
 * Author Shall
 */
public class DeviceDTO extends BaseObject implements java.io.Serializable {

    private Integer deviceId;
    private String serialNumber;

    public DeviceDTO() {
    }

    public DeviceDTO(String serialNumber) {
        this.serialNumber = serialNumber;
    }

    public DeviceDTO(Integer deviceId, String serialNumber) {
        this.deviceId = deviceId;
        this.serialNumber = serialNumber;
    }

    public Integer getDeviceId() {
        return this.deviceId;
    }

    public void setDeviceId(Integer deviceId) {
        this.deviceId = deviceId;
    }

    public String getSerialNumber() {
        return this.serialNumber;
    }

    public void setSerialNumber(String serialNumber) {
        this.serialNumber = serialNumber;
    }

}
