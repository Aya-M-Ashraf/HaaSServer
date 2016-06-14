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
    private long gizaDist;
    private long mansouraDist;
    private long suezDist;
    private long cairoDist;
    private long alexDist;

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

    public long getGizaDist() {
        return gizaDist;
    }

    public void setGizaDist(long gizaDist) {
        this.gizaDist = gizaDist;
    }

    public long getMansouraDist() {
        return mansouraDist;
    }

    public void setMansouraDist(long mansouraDist) {
        this.mansouraDist = mansouraDist;
    }

    public long getSuezDist() {
        return suezDist;
    }

    public void setSuezDist(long suezDist) {
        this.suezDist = suezDist;
    }

    public long getCairoDist() {
        return cairoDist;
    }

    public void setCairoDist(long cairoDist) {
        this.cairoDist = cairoDist;
    }

    public long getAlexDist() {
        return alexDist;
    }

    public void setAlexDist(long alexDist) {
        this.alexDist = alexDist;
    }    
       
}
