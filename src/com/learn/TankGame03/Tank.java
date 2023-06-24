package com.learn.TankGame03;

public class Tank {
    private int x;//x坐标
    private int y;//y坐标
    private int dir;
    boolean isLive = true;
    private int speed = 1;

    public void moveUp() {
        if (y > 0) y -= speed;
    }
    public void moveRight() {
        if (x + 60 < 1000) x += speed;
    }
    public void moveLeft() {
        if (x > 0) x -= speed;
    }
    public void moveDown() {
        if (y + 60 < 800) y += speed;
    }
    public Tank(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public int getSpeed() {
        return speed;
    }

    public void setSpeed(int speed) {
        this.speed = speed;
    }

    public int getDir() {
        return dir;
    }

    public void setDir(int dir) {
        this.dir = dir;
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }
}
