package com.czg.fish;

/**
 * @author chenzhigong
 * @date 2018-08-12 14:41
 * @description
 **/
public class MyMouseListener implements java.awt.event.MouseListener,java.awt.event.MouseMotionListener{
    @SuppressWarnings("unused")
    private int x1,y1,x2,y2;

    // 鼠标按键在组件上单击（按下并释放）时调用。
    public void mouseClicked(java.awt.event.MouseEvent e){


    }
    // 鼠标进入到组件上时调用。
    public void mouseEntered(java.awt.event.MouseEvent e) {


    }
    // 鼠标离开组件时调用。
    public void mouseExited(java.awt.event.MouseEvent e) {

    }

    //按压
    public void mousePressed(java.awt.event.MouseEvent e) {
        x1 = e.getX();
        y1 = e.getY();

    }
    // 鼠标按钮在组件上释放时调用。
    public void mouseReleased(java.awt.event.MouseEvent e) {

    }
    //鼠标按下并拖动时调用
    public void mouseDragged(java.awt.event.MouseEvent e){
        x2 = e.getX();
        y2 = e.getY();
        Fish.eat_x=x2;
        Fish.eat_y=y2;
        Fish.list.add(x2);
        x1 = x2;
        y1 = y2;

    }




    //鼠标光标在组件上按下并移动时调用
    public void mouseMoved(java.awt.event.MouseEvent e){


    }

}
