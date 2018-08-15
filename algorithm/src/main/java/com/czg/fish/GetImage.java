package com.czg.fish;

/**
 * @author chenzhigong
 * @date 2018-08-12 14:41
 * @description
 **/
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;

public class GetImage {

    //得到窗体的工具包
    public Toolkit tool = Toolkit.getDefaultToolkit();
    //得到开始界面图片
    Image start_1 = tool.getImage(GetImage.class.getResource("start_1.png"));
    Image start_2 = tool.getImage(GetImage.class.getResource("start_2.png"));
    Image main_bg_1 = tool.getImage(GetImage.class.getResource("mainbg.png"));

    DrawStart StartBg = null;
    //通过构造方法传递窗体对象
    public GetImage(DrawStart StartBg){
        this.StartBg = StartBg;
    }

    //画游戏开始时的图片
    public void startBackground(Graphics g){
        g.drawImage(start_1, 0, 0,StartBg.getWidth(),StartBg.getHeight(), StartBg);
    }
    //画加载时的背景
    public void loadBackground(Graphics g){

        g.drawImage(main_bg_1, 0, 0,StartBg.getWidth(),StartBg.getHeight(), StartBg);
    }

}
