package com.czg.fish;

/**
 * @author chenzhigong
 * @date 2018-08-12 14:39
 * @description
 **/
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Rectangle;
import java.awt.Toolkit;
import java.util.Random;

public class EatenFish {
    //得到窗体的工具包
    public Toolkit tool = Toolkit.getDefaultToolkit();
    //得到被吃的小鱼的图片

    Random r = new Random();
    //获取向左图片
    Image smallFish_1 = tool.getImage(DrawStart.class.getResource("eatenfish_right/"+r.nextInt(3)+".gif"));
    //Image bigFish_1 = tool.getImage(DrawStart.class.getResource("eatenfish_right/"+2+".gif"));
    //向右游动的初始坐标
    Image smallFish_2 = tool.getImage(DrawStart.class.getResource("eatenfish_left/"+r.nextInt(3)+".gif"));
    //Image bigFish_2 = tool.getImage(DrawStart.class.getResource("eatenfish_right/"+2+".gif"));
    //向右游动的初始坐标
    int eaten_x = 0;
    int eaten_y = 0;


    //存储判断传过来的数 0表示向右游 反之向左
    int m = 0;

    DrawStart StartBg =null;
    //通过构造方法传递窗体类和被吃鱼的初始坐标

    public EatenFish(DrawStart StartBg,int eaten_x,int eaten_y,int m){

        this.StartBg = StartBg;
        if(this.m == m ){
            this.eaten_x = eaten_x;
        }else{
            //向左游的初始坐标
            this.eaten_x = 1000;
        }
        this.eaten_y = eaten_y;

    }

    public EatenFish(DrawStart StartBg){
        this.StartBg = StartBg;
    }

    //定义定时器
    int time = 0;
    //定义存储随机数变量,如果随机数等于0画向右的鱼 等于1画向左的鱼
    int oo = 0;

    //画被吃的鱼
    public void drawEatenfish(Graphics g){
        if(time%(StartBg.getWidth()+100)==0){
            oo = r.nextInt(5);
        }
        if(oo==0){
            g.drawImage(smallFish_1, eaten_x, eaten_y,70,60, StartBg);
            fishmove_right();
        }
        if(oo==1){
            g.drawImage(smallFish_2, eaten_x, eaten_y, 70,60,StartBg);
            fishmove_left();
        }
        if(oo==2){
            g.drawImage(smallFish_1, eaten_x, eaten_y,70,60, StartBg);
            fishmove_lu();
        }
        if(oo==3){
            g.drawImage(smallFish_2, eaten_x, eaten_y, 70,60,StartBg);
            fishmove_ru();
        }

        time++;
    }

    //画被吃的鱼的游动 右边
    public void fishmove_right(){
        eaten_x +=3;
        if(eaten_x >= StartBg.getWidth()){
            StartBg.eatenfish_list.remove(this);
            eaten_x = 0;
        }

    }
    //画被吃的鱼的游动 左边
    public void fishmove_left(){
        eaten_x -=3;
        if(eaten_x <= -50){
            StartBg.eatenfish_list.remove(this);
            eaten_x = 1000;
        }

    }
    //画左斜线
    public void fishmove_lu(){
        eaten_x +=2;
        eaten_y +=2;
        if(eaten_x >1000&&eaten_y>750){
            StartBg.eatenfish_list.remove(this);
            eaten_x = 0;
            eaten_y = 1000;
        }

    }
    //画右斜线
    public void fishmove_ru(){
        eaten_x -=2;
        eaten_y +=2;
        if(eaten_x <= -50&&eaten_y>1000){
            StartBg.eatenfish_list.remove(this);
            eaten_x = 1000;
            eaten_y = 0;
        }

    }

    //返回被吃鱼的矩形区域
    public Rectangle getRectangle(){
        return new Rectangle(eaten_x, eaten_y, 60,50);
    }


}
