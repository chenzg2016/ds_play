package com.czg.park1;

/**
 * @author chenzg
 * @date 2019.04.14 12:40
 * @description
 * S, M, L
 * Motocyle(S, M, L)
 * Car(M,L)
 * Bus(4 x L)
 *
 * in / out
 * 显示没空闲每种停车位个数
 * find car by liscense number 通过车牌号寻找所停位置号码
 *
 **/
public class ParkApp {
    public static void main(String[] args) {
        Drive drive = new Drive("S","浙A 19999",null);
        Drive drive1 = new Drive("M","浙B 19999",null);
        Drive drive2 = new Drive("S","浙C 19999",null);
        Drive drive3 = new Drive("L","浙D 19999",null);
        Drive drive4 = new Drive("L","浙E 19999",null);
        ParkPlace1  p = new ParkPlace1(2,5,2);
        p.in(drive);
        p.in(drive4);
        p.in(drive1);
        p.in(drive2);
        p.in(drive3);
        p.in(drive4);
        p.getDrivePosition(drive2);
        p.getDrivePosition(drive1);
        p.getDrivePosition(drive);
        p.getDrivePosition(drive4);
        p.getDrivePosition(drive3);
        p.out(drive1);
        p.out(drive);
        p.out(drive2);
        p.out(drive3);
        p.out(drive4);

    }
}
