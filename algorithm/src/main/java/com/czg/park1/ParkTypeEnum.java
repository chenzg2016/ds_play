package com.czg.park1;

/**
 * @author chenzg
 * @date 2019.04.14 12:37
 * @description
 **/
public enum ParkTypeEnum {

    S("S"),M("M"),L("L");
    ParkTypeEnum(String type){
        this.type = type;
    }
    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    private String type;


}
