package com.haas.webview.bean;

/**
 *
 * @author Aya M. Ashraf
 */
public class AdminReportBean {
    
    private long usersCount;
    private long femaleUsersCount;
    private long maleUsersCount;
    private long devicesCount;
    private long connectionsCount;
    private double totalMegaBytes;

    public AdminReportBean() {
    }

    public long getUsersCount() {
        return usersCount;
    }

    public void setUsersCount(long usersCount) {
        this.usersCount = usersCount;
    }

    public long getDevicesCount() {
        return devicesCount;
    }

    public void setDevicesCount(long devicesCount) {
        this.devicesCount = devicesCount;
    }

    public long getConnectionsCount() {
        return connectionsCount;
    }

    public void setConnectionsCount(long connectionsCount) {
        this.connectionsCount = connectionsCount;
    }

    public double getTotalMegaBytes() {
        return totalMegaBytes;
    }

    public void setTotalMegaBytes(double totalMegaBytes) {
        this.totalMegaBytes = totalMegaBytes;
    }

    public long getFemaleUsersCount() {
        return femaleUsersCount;
    }

    public void setFemaleUsersCount(long femaleUsersCount) {
        this.femaleUsersCount = femaleUsersCount;
    }

    public long getMaleUsersCount() {
        return maleUsersCount;
    }

    public void setMaleUsersCount(long maleUsersCount) {
        this.maleUsersCount = maleUsersCount;
    }
       
}
