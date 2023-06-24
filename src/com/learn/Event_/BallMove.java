package com.learn.Event_;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class BallMove extends JFrame{
    MyPanel mp;
    public static void main(String[] args) {
        BallMove ballMove = new BallMove();
    }
    public BallMove() {
        mp = new MyPanel();
        this.add(mp);
        this.addKeyListener(mp); //添加监听器
        this.setSize(400, 300);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setVisible(true);
    }
}

class MyPanel extends JPanel implements KeyListener {
    int x = 10;
    int y = 10;
    @Override
    public void paint(Graphics g) {
        super.paint(g);
        g.fillOval(x, y, 20, 20);
    }
    //有字符输出，触发方法
    @Override
    public void keyTyped(KeyEvent e) {

    }
    //按下
    @Override
    public void keyPressed(KeyEvent e) {
        System.out.println(e.getKeyChar() + "被按下");
        if (e.getKeyCode() == KeyEvent.VK_S) {//向下按键
            y++;
        } else if (e.getKeyCode() == KeyEvent.VK_A) {
            x--;
        } else if (e.getKeyCode() == KeyEvent.VK_D) {
            x++;
        } else if (e.getKeyCode() == KeyEvent.VK_W) {
            y--;
        }
        this.repaint();
    }
    //松开
    @Override
    public void keyReleased(KeyEvent e) {

    }
}
