package com.learn.TankGame02;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.Vector;

public class MyPanel extends JPanel implements KeyListener {
    //定义坦克
    MyTank myTank;
    Vector<EnemyTank> enemyTanks = new Vector<>();
    int enemyTankSize = 3;
    public MyPanel() {
        myTank = new MyTank(100, 100);
        myTank.setSpeed(6);
        //初始化敌人坦克
        for (int i = 0; i < enemyTankSize; i++) {
            //enemyTanks.add(new EnemyTank((int)(Math.random()*500), (int)(Math.random()*500)));
            EnemyTank enemyTank = new EnemyTank((100 * (i + 1)), 0);
            enemyTank.setDir(3);
            enemyTanks.add(enemyTank);
        }
    }

    @Override
    public void paint(Graphics g) {
        super.paint(g);
        g.fillRect(0, 0, 1000, 750);
        //画出我的坦克
        drawTank(myTank.getX(), myTank.getY(), g, myTank.getDir(), 0);
        //drawTank(myTank.getX() + 80, myTank.getY(), g, 0, 1);
        //画出敌人坦克
        for (int i = 0; i < enemyTanks.size(); i++) {
            EnemyTank enemyTank = enemyTanks.get(i);
            drawTank(enemyTank.getX(), enemyTank.getY(), g, enemyTank.getDir(), 1);
        }
    }
    //画坦克方法
    /**
     * @param x 坦克左上角x坐标
     * @param y 坦克左上角y坐标
     * @param g 画笔
     * @param direct 坦克方向上下左右
     * @param type 坦克类型
     */
    public void drawTank(int x, int y, Graphics g, int direct, int type) {
        switch (type) {
            case 0 -> //我的坦克
                    g.setColor(Color.CYAN);
            case 1 -> //敌人坦克
                    g.setColor(Color.YELLOW);
        }

        //根据坦克方向来绘制坦克
        switch (direct) {
            case 0 -> { //向上
                g.fill3DRect(x, y, 10, 60, false);//左轮子
                g.fill3DRect(x + 30, y, 10, 60, false);//右轮子
                g.fill3DRect(x + 10, y + 10, 20, 40, false);//中间身体
                g.fillOval(x + 10, y + 20, 20, 20);//圆盖
                g.drawLine(x + 20, y + 30, x + 20, y);//炮筒
            }
            case 1 -> { //向右
                g.fill3DRect(x, y, 60, 10, false);//左轮子
                g.fill3DRect(x, y + 30, 60, 10, false);//右轮子
                g.fill3DRect(x + 10, y + 10, 40, 20, false);//中间身体
                g.fillOval(x + 20, y + 10, 20, 20);//圆盖
                g.drawLine(x + 30, y + 20, x + 60, y + 20);//炮筒
            }
            case 2 -> { //向左
                g.fill3DRect(x, y, 60, 10, false);//左轮子
                g.fill3DRect(x, y + 30, 60, 10, false);//右轮子
                g.fill3DRect(x + 10, y + 10, 40, 20, false);//中间身体
                g.fillOval(x + 20, y + 10, 20, 20);//圆盖
                g.drawLine(x + 30, y + 20, x, y + 20);//炮筒
            }
            case 3 -> { //向下
                g.fill3DRect(x, y, 10, 60, false);//左轮子
                g.fill3DRect(x + 30, y, 10, 60, false);//右轮子
                g.fill3DRect(x + 10, y + 10, 20, 40, false);//中间身体
                g.fillOval(x + 10, y + 20, 20, 20);//圆盖
                g.drawLine(x + 20, y + 30, x + 20, y + 60);//炮筒
            }
            default -> System.out.println("无");
        }
    }

    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {
        if (e.getKeyCode() == KeyEvent.VK_W) { //按下w按键
            myTank.setDir(0);
            myTank.moveUp();
        } else if (e.getKeyCode() == KeyEvent.VK_D) {
            myTank.setDir(1);
            myTank.moveRight();
        } else if (e.getKeyCode() == KeyEvent.VK_A) {
            myTank.setDir(2);
            myTank.moveLeft();
        }else if (e.getKeyCode() == KeyEvent.VK_S) {
            myTank.setDir(3);
            myTank.moveDown();
        }
        this.repaint();
    }

    @Override
    public void keyReleased(KeyEvent e) {

    }
}
