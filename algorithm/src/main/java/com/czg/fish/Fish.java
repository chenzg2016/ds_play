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
import java.util.ArrayList;
import java.util.List;

public class Fish {
    int count = 0;//统计吃鱼的个数
    static List<Integer> list = new ArrayList<Integer>() ;
    Rectangle  rect ;

    //得到窗体的工具包
    Toolkit tool = Toolkit.getDefaultToolkit();

    //得到主角图片
    Image fish_right = tool.getImage(Fish.class.getResource("right.png"));
    Image fish_left = tool.getImage(Fish.class.getResource("left.png"));

    private DrawStart StartBg = null ;

    public Fish(DrawStart StartBg){
        this.StartBg=StartBg;

    }
    static int eat_x = 400;
    static int eat_y = 350;

    //创建被吃鱼类对象
    EatenFish eatenfish = new EatenFish(StartBg);

    //画主角鱼
    public void drawFish(Graphics g) {
        if(count<25){
            if(list.get(list.size()-2)<list.get(list.size()-1)){
                g.drawImage(fish_right,eat_x-40,eat_y-35,80,70,StartBg);
            }else{
                g.drawImage(fish_left,eat_x-40,eat_y-35,80,70,StartBg);
            }
        }else{
            if(list.get(list.size()-2)<list.get(list.size()-1)){
                g.drawImage(fish_right,eat_x-55,eat_y-48,110,96,StartBg);
            }else{
                g.drawImage(fish_left,eat_x-55,eat_y-48,110,96,StartBg);
            }
        }
        if(list.size()>4){
            list.remove(0);
            list.remove(1);
        }
        eatenFish_bye();
    }

    //返回主角鱼的矩形区域
    public Rectangle getRectangle(){
        if(count<25){
            rect = new Rectangle(eat_x-35, eat_y-30, 70,60);
        }else{
            rect = new Rectangle(eat_x-50, eat_y-43, 100,87);
        }
        return rect;
    }

    //被吃鱼消失
    public void eatenFish_bye(){
        for(int i=0;i<StartBg.eatenfish_list.size();i++){
            EatenFish eatenfish = StartBg.eatenfish_list.get(i);
            //判断两个矩形区域是否相交
            if(getRectangle().intersects(eatenfish.getRectangle()) || eatenfish.getRectangle().intersects(getRectangle())){
                StartBg.eatenfish_list.remove(eatenfish);
                StartBg.music.playEatMusic();
                count++;
            }
        }

    }
}
