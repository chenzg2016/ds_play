package com.czg.block;

/**
 * @author chenzhigong
 * @date 2018-08-12 14:25
 * @description
 **/
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import javax.swing.*;
import javax.swing.Timer;

public class Tetris extends JFrame {
    public Tetris() {
        Tetrisblok a = new Tetrisblok();
        addKeyListener(a);
        add(a);
    }

    public static void main(String[] args) {
        Tetris frame = new Tetris();
        JMenuBar menu = new JMenuBar();
        frame.setJMenuBar(menu);
        JMenu game = new JMenu("游戏");
        JMenuItem newgame = game.add("新游戏");
        JMenuItem pause = game.add("暂停");
        JMenuItem goon = game.add("继续");
        JMenuItem exit = game.add("退出");
        JMenu help = new JMenu("帮助");
        JMenuItem about = help.add("关于");
        menu.add(game);
        menu.add(help);
        frame.setLocationRelativeTo(null);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(220, 275);
        frame.setTitle("Tetris内测版");
        // frame.setUndecorated(true);
        frame.setVisible(true);
        frame.setResizable(false);

    }
}