package com.czg.serializable;

import java.io.Serializable;

/**
 * @author chenzg
 * @date 8/2/21 5:00 PM
 * @description
 */
public class GamePerson implements Serializable {

    private static final long serialVersionUID = -8497204661943693143L;
    private String name;
    public static int level;
    private int forceValue;
    private int defenseValue;
    // 金额是敏感数据：不对此属性进行序列化
    private transient long money;

    public long getMoney() {
        return money;
    }

    public void setMoney(long money) {
        this.money = money;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }

    public int getForceValue() {
        return forceValue;
    }

    public void setForceValue(int forceValue) {
        this.forceValue = forceValue;
    }

    public int getDefenseValue() {
        return defenseValue;
    }

    public void setDefenseValue(int defenseValue) {
        this.defenseValue = defenseValue;
    }

}
