package com.czg.park1;

import java.util.*;

/**
 * @author chenzg
 * @date 2019.04.14 13:26
 * @description
 **/
public class ParkPlace1 {
    private  Integer smallCount;

    private  Integer mediumCount;

    private  Integer largeCount;

    private  Set<Integer> smallSet = new HashSet();
    private  Set<Integer> mediumSet = new HashSet();
    private  Set<Integer> largeSet = new HashSet();

    private Map<String,Integer> driveNumAndPositionMap = new HashMap();

    private Map<String,String> driveNumAndParkTypeMap = new HashMap();


    public ParkPlace1(Integer sCount,Integer mCount, Integer lCount){

            this.smallCount = sCount;
            this.mediumCount = mCount;
            this.largeCount = lCount;
            initPositionNum(smallSet,this.smallCount);
            initPositionNum(mediumSet,this.mediumCount);
            initPositionNum(largeSet,this.largeCount);
    }

    /**
     *   车辆进厂
     * @param drive
     */
    public void in(Drive drive){
        // 卫语句
        if (null != driveNumAndPositionMap.get(drive.getDriveNum())) {
            System.out.println("车辆" + drive.getDriveNum() + "已入场，请人工核对！");
            return;
        }

        //根据车辆类型选择停车位
        if(ParkTypeEnum.S.name().equals(drive.getType())){
            if (getSmallCount() > 0){
                driveNumAndPositionMap.put(drive.getDriveNum(),smallSet.iterator().next());
                smallSet.remove(driveNumAndPositionMap.get(drive.getDriveNum()));
                driveNumAndParkTypeMap.put(drive.getDriveNum(),ParkTypeEnum.S.name());
                setSmallCount(getSmallCount() -1);
            }else if (getMediumCount() > 0){
                driveNumAndPositionMap.put(drive.getDriveNum(),mediumSet.iterator().next());
                mediumSet.remove(driveNumAndPositionMap.get(drive.getDriveNum()));

                driveNumAndParkTypeMap.put(drive.getDriveNum(),ParkTypeEnum.M.name());

                setMediumCount(getMediumCount() -1);

            }else if (getLargeCount() > 0){
                driveNumAndPositionMap.put(drive.getDriveNum(),largeSet.iterator().next());
                largeSet.remove(driveNumAndPositionMap.get(drive.getDriveNum()));

                driveNumAndParkTypeMap.put(drive.getDriveNum(),ParkTypeEnum.L.name());

                setLargeCount(getLargeCount() - 1);
            }else {
                System.out.println("车位已满，请调头");
                return;
            }
        }else  if(ParkTypeEnum.M.name().equals(drive.getType())){
            if (getMediumCount() > 0){
                driveNumAndPositionMap.put(drive.getDriveNum(),mediumSet.iterator().next());
                driveNumAndParkTypeMap.put(drive.getDriveNum(),ParkTypeEnum.M.name());
                mediumSet.remove(driveNumAndPositionMap.get(drive.getDriveNum()));

                setMediumCount(getMediumCount() -1);

            }else if (getLargeCount() > 0){
                driveNumAndPositionMap.put(drive.getDriveNum(),largeSet.iterator().next());
                driveNumAndParkTypeMap.put(drive.getDriveNum(),ParkTypeEnum.L.name());
                largeSet.remove(driveNumAndPositionMap.get(drive.getDriveNum()));

                setLargeCount(getLargeCount() - 1);
            }else {
                System.out.println("车位已满，请调头");
                return;
            }
        }else if(ParkTypeEnum.L.name().equals(drive.getType())){
            if (getLargeCount() >= 4){
                driveNumAndPositionMap.put(drive.getDriveNum(),largeSet.iterator().next());
                driveNumAndParkTypeMap.put(drive.getDriveNum(),ParkTypeEnum.L.name());
                largeSet.remove(driveNumAndPositionMap.get(drive.getDriveNum()));
                largeSet.remove(driveNumAndPositionMap.get(drive.getDriveNum()) + 1);
                largeSet.remove(driveNumAndPositionMap.get(drive.getDriveNum()) + 2);
                largeSet.remove(driveNumAndPositionMap.get(drive.getDriveNum()) +  3);

                setLargeCount(getLargeCount() - 4 < 0 ? 0 : getLargeCount() - 4);
            }else {
                System.out.println("车位已满，请调头");
                return;
            }
        }

        System.out.print(drive.getDriveNum() + "车辆进厂后，S车位数量剩余:" + getSmallCount());
        System.out.print(";M车位数量剩余:" + getMediumCount());
        System.out.println(";L车位数量剩余:" + getLargeCount());

    }

    /**
     * 车辆离场
     * @param drive
     */
    public void out(Drive drive){
        if(ParkTypeEnum.S.name().equals(driveNumAndParkTypeMap.get(drive.getDriveNum()))) {
            setSmallCount(getSmallCount() + 1);
        }else if (ParkTypeEnum.M.name().equals(driveNumAndParkTypeMap.get(drive.getDriveNum()))){
            setMediumCount(getMediumCount() + 1);
        }else if (ParkTypeEnum.L.name().equals(driveNumAndParkTypeMap.get(drive.getDriveNum()))) {
            if(ParkTypeEnum.L.name().equals(drive.getType())) {
                setLargeCount(getLargeCount() + 4);
            }else {
                setLargeCount(getLargeCount() + 1);
            }

        }
        System.out.print(drive.getDriveNum() + "车辆出厂后，S车位数量剩余:" + getSmallCount());
        System.out.print(";M车位数量剩余:" + getMediumCount());
        System.out.println(";L车位数量剩余:" + getLargeCount());
    }

    /**
     * 查找车牌对应的车辆的停车位
     * @param drive
     */
    public void getDrivePosition(Drive drive){
        Integer p = driveNumAndPositionMap.get(drive.getDriveNum());
        if (null != p) {
            System.out.println("车牌"+drive.getDriveNum() + "停在" + p + "号车位");
        }else {
            System.out.println("未查询到" + "车牌"+drive.getDriveNum() + "进厂信息");
        }
    }

    private Integer getSmallCount() {
        return smallCount;
    }

    private void setSmallCount(Integer smallCount) {
        this.smallCount = smallCount;
    }

    private Integer getMediumCount() {
        return mediumCount;
    }

    private void setMediumCount(Integer mediumCount) {
        this.mediumCount = mediumCount;
    }

    private Integer getLargeCount() {
        return largeCount;
    }

    private void setLargeCount(Integer largeCount) {
        this.largeCount = largeCount;
    }


    /**
     * 初始化车位号码
     * @param set
     * @param count
     */
    private void initPositionNum(Set set,Integer count){
       for (int i = 1;i <= count; i++) {
           set.add(i);
       }
    }


}
