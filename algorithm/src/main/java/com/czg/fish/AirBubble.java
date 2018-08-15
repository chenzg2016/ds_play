package com.czg.fish;

/**
 * @author chenzhigong
 * @date 2018-08-12 14:38
 * @description
 **/

import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;

public class AirBubble {
    //得到窗体的工具包
    Toolkit tool = Toolkit.getDefaultToolkit();
    Image air = tool.getImage( AirBubble.class.getResource("qipao.png"));// 气泡图片
    Image air_1 = tool.getImage( AirBubble.class.getResource("qipao.png"));//气泡图片

    //设置气泡的初始坐标
    int air_x = 0;
    int air_y = 705;


    DrawStart StartBg = null;
    //通过构造方法传递窗体对象和气泡的初始位置
    public AirBubble(DrawStart StartBg,int air_x,int air_y){
        this.StartBg = StartBg;
        this.air_x = air_x;
        this.air_y = air_y;

    }

    //画气泡
    public void drawAirBubble(Graphics g){
        g.drawImage(air, air_x, air_y, StartBg);

        moveBackGround();
    }

    //气泡的移动
    public void moveBackGround(){
        air_y -=5;
        if(air_y <=0){
            StartBg.air_list.remove(this);
            air_y = 705;
        }
    }


}