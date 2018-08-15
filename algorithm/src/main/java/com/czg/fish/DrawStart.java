package com.czg.fish;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import java.util.Random;

/**
 * @author chenzhigong
 * @date 2018-08-12 14:37
 * @description
 **/

public class DrawStart extends JFrame {
    int Gametype = 0;

    public Toolkit tool = Toolkit.getDefaultToolkit();//得到窗体的工具包

    Image logo = tool.getImage(DrawStart.class.getResource("logo.png"));//窗体标志

    //创建缓冲图片
    Image bg_img = null;

    //创建线程类对象
    MyThread thread = new MyThread();

    //创建一个集合存放多个气泡
    ArrayList<AirBubble> air_list = new ArrayList<AirBubble>();

    //创建鱼类对象
    private Fish fish = new Fish(this);


    //创建一个集合存放多个被吃的鱼
    ArrayList<EatenFish> eatenfish_list = new ArrayList<EatenFish>();

    //创建背景类对象
    GetImage startBg = new GetImage(this);

    //创建一个音乐对象
    Music music = new Music();

    //显示游戏界面
    public void showFrame(){
        this.setTitle("大鱼吃小鱼");
        this.setSize(850,710);
        this.setResizable(false);
        setIconImage(logo);//窗体上的标志

        //设置窗体可见
        this.setVisible(true);


        //添加鼠标监听
        MyMouseListener mouse_listener = new MyMouseListener();
        this.addMouseListener(mouse_listener);
        this.addMouseMotionListener(mouse_listener);
        //添加键盘监听
        addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent key) {
                if (key.getKeyCode() == 10 && Gametype == 0) {

                    Gametype = 1;
                    music.playBgMusic();
                    repaint();

                }

            }

        });
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);//关闭窗体
        thread.start();
    }

    public void createFish(){
        //Fish fish = new Fish(370,300);
        Fish fish = new Fish(this);
    }
    //创建随机数对象
    Random r = new Random();
    //创建被吃的鱼
    public void createEatenfish() {
        if (r.nextInt(2) == 0) {
            EatenFish cr_eatenfish = new EatenFish(this, -50, r.nextInt(705),r.nextInt(2));
            eatenfish_list.add(cr_eatenfish);
        }
        if (r.nextInt(2) == 1) {
            EatenFish cr_eatenfish = new EatenFish(this, getWidth() + 110, r.nextInt(705),r.nextInt(2));
            eatenfish_list.add(cr_eatenfish);
        }
    }

    //创建气泡
    public void createAirBubble() {
        music.playBubblesMusic();
        AirBubble ab_air = new AirBubble(this, r.nextInt(getWidth() - 40), 705);
        air_list.add(ab_air);
    }

    //重写paint方法
    @Override
    public void paint(Graphics p) {
        //判断游戏是否是开始的
        if (Gametype == 0) {
            startBg.startBackground(p);
        }
        //判断游戏是否是在加载中
        if (Gametype == 1) {
            startBg.loadBackground(p);

            for (int i = 0; i < eatenfish_list.size(); i++) {
                EatenFish eatenfish = eatenfish_list.get(i);
                // 画被吃的鱼
                eatenfish.drawEatenfish(p);
            }

            for (int i = 0; i < air_list.size(); i++) {
                AirBubble Dr_qipao = air_list.get(i);
                //画气泡
                Dr_qipao.drawAirBubble(p);
            }

            fish.drawFish(p);//画主角


        }

    }

    // 创建定时器
    int time = 0;
    int eaten = 0;
    // 内部类,不停的重绘窗体图像
    private class MyThread extends Thread {
        @Override
        public void run() {
            Fish.list.add( 1);
            Fish.list.add( 2);
            while (true) {
                try {
                    Thread.sleep(50);
                    time++;
                    eaten++;
                    createFish();
                    if (Gametype == 1 && time % 25 == 0) {
                        createAirBubble();
                        time = 0;
                    }
                    if (Gametype == 1 && eaten % 10 == 0) {
                        createEatenfish();
                        eaten = 0;
                    }

                    //重绘
                    repaint();
                } catch (InterruptedException e) {

                    e.printStackTrace();
                }

            }
        }

    }

    public static void main(String[] args){
        DrawStart ds = new DrawStart();
        ds.showFrame();
    }
}
