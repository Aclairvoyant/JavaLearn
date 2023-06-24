package com.learn.TankGame03;

import java.util.Vector;

public class EnemyTank extends Tank implements Runnable{
    Vector<Shot> shots = new Vector<>();
    Vector<EnemyTank> enemyTanks = new Vector<>();
    boolean isLive = true;
    public EnemyTank(int x, int y) {
        super(x, y);
    }

    public void setEnemyTanks(Vector<EnemyTank> enemyTanks) {
        this.enemyTanks = enemyTanks;
    }

    //判断当前敌人坦克是否和其他坦克碰撞
    public boolean isTouchEnemyTank() {
        //判断当前坦克方向
        switch (this.getDir()) {
            case 0 -> {
                for(int i = 0; i < enemyTanks.size(); i ++) {
                    //从Vector中取出一个坦克
                    EnemyTank enemyTank = enemyTanks.get(i);
                    //不和自己比较
                    if (enemyTank != this) {
                        //如果敌人坦克方向是上下
                        if (enemyTank.getDir() == 0 || enemyTank.getDir() == 2) {
                            //当前坦克左上角和右上角进入敌人区域
                            if (this.getX() >= enemyTank.getX() && this.getX() <= enemyTank.getX() + 40
                            && this.getY() >= enemyTank.getY() && this.getY() <= enemyTank.getY() + 60) {
                                return true;
                            }
                            if (this.getX() + 40 >= enemyTank.getX() && this.getX() + 40 <= enemyTank.getX() + 40
                                    && this.getY() >= enemyTank.getY() && this.getY() <= enemyTank.getY() + 60) {
                                return true;
                            }
                        }
                        //左右
                        if (enemyTank.getDir() == 1 || enemyTank.getDir() == 3) {
                            if (this.getX() >= enemyTank.getX() && this.getX() <= enemyTank.getX() + 60
                                    && this.getY() >= enemyTank.getY() && this.getY() <= enemyTank.getY() + 40) {
                                return true;
                            }
                            if (this.getX() + 40 >= enemyTank.getX() && this.getX() + 40 <= enemyTank.getX() + 60
                                    && this.getY() >= enemyTank.getY() && this.getY() <= enemyTank.getY() + 40) {
                                return true;
                            }
                        }
                    }
                }
            }
            case 1 -> {
                for(int i = 0; i < enemyTanks.size(); i ++) {
                    //从Vector中取出一个坦克
                    EnemyTank enemyTank = enemyTanks.get(i);
                    //不和自己比较
                    if (enemyTank != this) {
                        //如果敌人坦克方向是上下
                        if (enemyTank.getDir() == 0 || enemyTank.getDir() == 2) {
                            //当前坦克右上角和右下角进入敌人区域
                            if (this.getX() + 60 >= enemyTank.getX() && this.getX() + 60 <= enemyTank.getX() + 40
                                    && this.getY() >= enemyTank.getY() && this.getY() <= enemyTank.getY() + 60) {
                                return true;
                            }
                            if (this.getX() + 60 >= enemyTank.getX() && this.getX() + 60 <= enemyTank.getX() + 40
                                    && this.getY() + 40 >= enemyTank.getY() && this.getY() + 40 <= enemyTank.getY() + 60) {
                                return true;
                            }
                        }
                        //左右
                        if (enemyTank.getDir() == 1 || enemyTank.getDir() == 3) {
                            if (this.getX() + 60 >= enemyTank.getX() && this.getX() + 60 <= enemyTank.getX() + 60
                                    && this.getY() >= enemyTank.getY() && this.getY() <= enemyTank.getY() + 40) {
                                return true;
                            }
                            if (this.getX() + 60 >= enemyTank.getX() && this.getX() + 60 <= enemyTank.getX() + 60
                                    && this.getY() + 40 >= enemyTank.getY() && this.getY() + 40 <= enemyTank.getY() + 40) {
                                return true;
                            }
                        }
                    }
                }
            }
            case 2 -> {
                for(int i = 0; i < enemyTanks.size(); i ++) {
                    //从Vector中取出一个坦克
                    EnemyTank enemyTank = enemyTanks.get(i);
                    //不和自己比较
                    if (enemyTank != this) {
                        //如果敌人坦克方向是上下
                        if (enemyTank.getDir() == 0 || enemyTank.getDir() == 2) {
                            //当前坦克左下角和右下角进入敌人区域
                            if (this.getX() >= enemyTank.getX() && this.getX() <= enemyTank.getX() + 40
                                    && this.getY() + 60 >= enemyTank.getY() && this.getY() + 60 <= enemyTank.getY() + 60) {
                                return true;
                            }
                            if (this.getX() + 40 >= enemyTank.getX() && this.getX() + 40 <= enemyTank.getX() + 40
                                    && this.getY() + 60 >= enemyTank.getY() && this.getY() + 60 <= enemyTank.getY() + 60) {
                                return true;
                            }
                        }
                        //左右
                        if (enemyTank.getDir() == 1 || enemyTank.getDir() == 3) {
                            if (this.getX() >= enemyTank.getX() && this.getX() <= enemyTank.getX() + 60
                                    && this.getY() + 60>= enemyTank.getY() && this.getY() + 60 <= enemyTank.getY() + 40) {
                                return true;
                            }
                            if (this.getX() + 40 >= enemyTank.getX() && this.getX() + 40 <= enemyTank.getX() + 60
                                    && this.getY() + 60 >= enemyTank.getY() && this.getY() + 60 <= enemyTank.getY() + 40) {
                                return true;
                            }
                        }
                    }
                }
            }
            case 3 -> {
                for(int i = 0; i < enemyTanks.size(); i ++) {
                    //从Vector中取出一个坦克
                    EnemyTank enemyTank = enemyTanks.get(i);
                    //不和自己比较
                    if (enemyTank != this) {
                        //如果敌人坦克方向是上下
                        if (enemyTank.getDir() == 0 || enemyTank.getDir() == 2) {
                            //当前坦克左上角和左下角进入敌人区域
                            if (this.getX() >= enemyTank.getX() && this.getX() <= enemyTank.getX() + 40
                                    && this.getY() >= enemyTank.getY() && this.getY() <= enemyTank.getY() + 60) {
                                return true;
                            }
                            if (this.getX() >= enemyTank.getX() && this.getX() <= enemyTank.getX() + 40
                                    && this.getY() + 40 >= enemyTank.getY() && this.getY() + 40 <= enemyTank.getY() + 60) {
                                return true;
                            }
                        }
                        //左右
                        if (enemyTank.getDir() == 1 || enemyTank.getDir() == 3) {
                            if (this.getX() >= enemyTank.getX() && this.getX() <= enemyTank.getX() + 60
                                    && this.getY() >= enemyTank.getY() && this.getY() <= enemyTank.getY() + 40) {
                                return true;
                            }
                            if (this.getX() >= enemyTank.getX() && this.getX() <= enemyTank.getX() + 60
                                    && this.getY() + 40 >= enemyTank.getY() && this.getY() + 40 <= enemyTank.getY() + 40) {
                                return true;
                            }
                        }
                    }
                }
            }
        }
        return false;
    }

    @Override
    public void run() {
        while(true) {
            //创建子弹
            if (isLive && shots.size() < 1) {
                //判断坦克方向，创建对应的子弹
                Shot s = null;
                switch (getDir()) {
                    case 0 -> s = new Shot(getX() + 20, getY(), 0);
                    case 1 -> s = new Shot(getX() + 60, getY() + 20, 1);
                    case 2 -> s = new Shot(getX() + 20, getY() + 60, 2);
                    case 3 -> s = new Shot(getX(), getY() + 20, 3);
                }
                shots.add(s);
                //启动
                new Thread(s).start();
            }
            //根据坦克的方向来继续移动
            switch (getDir()) {
                case 0 -> {
                    for (int i = 0; i < 30; i++) {
                        if (!isTouchEnemyTank())
                            moveUp();
                        try {
                            Thread.sleep(50);
                        } catch (InterruptedException e) {
                            throw new RuntimeException(e);
                        }
                    }
                }
                case 1 -> {
                    for (int i = 0; i < 30; i++) {
                        if (!isTouchEnemyTank())
                            moveRight();
                        try {
                            Thread.sleep(50);
                        } catch (InterruptedException e) {
                            throw new RuntimeException(e);
                        }
                    }
                }
                case 2 -> {
                    for (int i = 0; i < 30; i++) {
                        if (!isTouchEnemyTank())
                            moveDown();
                        try {
                            Thread.sleep(50);
                        } catch (InterruptedException e) {
                            throw new RuntimeException(e);
                        }
                    }
                }
                case 3 -> {
                    for (int i = 0; i < 30; i++) {
                        if (!isTouchEnemyTank())
                            moveLeft();
                        try {
                            Thread.sleep(50);
                        } catch (InterruptedException e) {
                            throw new RuntimeException(e);
                        }
                    }
                }
            }

            //然后随机地改变坦克方向
            setDir((int)(Math.random() * 4));//(int)(Math.random() * 4)
            if (! isLive) {
                break;
            }
        }
    }
}
