package com.learn.TankGame03;

public class Shot implements Runnable{
    int x;//子弹x坐标
    int y;//子弹y坐标
    int direct = 0;//子弹方向
    int speed = 3;//子弹速度
    boolean isLive = true;//子弹是否存活

    public Shot(int x, int y, int direct) {
        this.x = x;
        this.y = y;
        this.direct = direct;
    }

    @Override
    public void run() { //射击
        while(isLive) {
            try {
                Thread.sleep(50);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            switch (direct) {
                case 0 -> y -= speed; //上
                case 1 -> x += speed; //右
                case 2 -> y += speed; //下
                case 3 -> x -= speed; //左
            }
            System.out.println("子弹 x=" + x + " y=" + y);
            if (!(x >= 0 && x <= 1000 && y >= 0 && y <= 800)) {
                isLive = false;
                break;
            }
        }
    }
}
