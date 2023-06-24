package com.learn.TankGame03;

import java.util.Vector;

public class MyTank extends Tank {
    Shot shot; //定义一个Shot对象，表示一个射击线程
    Vector<Shot> shots = new Vector<>();//多发子弹
    public MyTank(int x, int y) {
        super(x, y);
    }
    //射击
    public void shotEnemy() {
        if (shots.size() == 5) {
            return;
        }//我方坦克一次最多五颗子弹

        switch (getDir()) { //得到MyTank的方向，射击子弹
            case 0 ->
                    shot = new Shot(getX() + 20, getY(), 0);
            case 1 ->
                    shot = new Shot(getX() + 60, getY() + 20, 1);
            case 2 ->
                    shot = new Shot(getX() + 20, getY() + 60, 2);
            case 3 ->
                    shot = new Shot(getX(), getY() + 20, 3);
        }
        shots.add(shot);
        //启动线程
        new Thread(shot).start();
    }
}
