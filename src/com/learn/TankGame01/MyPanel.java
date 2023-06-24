package com.learn.TankGame01;

import javax.swing.*;
import java.awt.*;

public class MyPanel extends JPanel {
    //定义坦克
    MyTank myTank = null;
    public MyPanel() {
        myTank = new MyTank(100, 100);
    }

    @Override
    public void paint(Graphics g) {
        super.paint(g);
        g.fillRect(0, 0, 1000, 750);

        drawTank(myTank.getX(), myTank.getY(), g, 0, 0);
        //drawTank(myTank.getX() + 80, myTank.getY(), g, 0, 1);
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
            case 0: //我的坦克
                g.setColor(Color.CYAN);
                break;
            case 1: //敌人坦克
                g.setColor(Color.YELLOW);
                break;
        }

        //根据坦克方向来绘制坦克
        switch (direct) {
            case 0: //向上
                g.fill3DRect(x, y, 10, 60, false);//左轮子
                g.fill3DRect(x+30, y, 10, 60, false);//右轮子
                g.fill3DRect(x+10, y+10, 20, 40, false);//中间身体
                g.fillOval(x+10, y+20,20, 20);//圆盖
                g.drawLine(x+20, y+30, x+20, y);//炮筒
                break;
            default:
                System.out.println("无");
        }
    }
}
