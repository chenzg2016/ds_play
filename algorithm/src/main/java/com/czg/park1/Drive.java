package com.czg.park1;

/**
 * @author chenzg
 * @date 2019.04.14 12:39
 * @description
 **/
public class Drive {
    private String type;
    private String driveNum;
    private String location;

    public Drive(String type, String driveNum, String location){
        this.type = type;
        this.driveNum = driveNum;
        this.location = location;
    }
    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getDriveNum() {
        return driveNum;
    }

    public void setDriveNum(String driveNum) {
        this.driveNum = driveNum;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

}
