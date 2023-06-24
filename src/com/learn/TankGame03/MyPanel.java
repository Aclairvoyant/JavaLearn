package com.learn.TankGame03;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.io.IOException;
import java.util.Vector;

public class MyPanel extends JPanel implements KeyListener, Runnable {
    //定义坦克
    MyTank myTank;
    Vector<EnemyTank> enemyTanks = new Vector<>();
    //定义一个存放Node对象的Vector，用于恢复坦克坐标方向
    Vector<Node> nodes;
    //存放炸弹
    Vector<Bomb> bombs = new Vector<>();
    int enemyTankSize = 3;
    //定义爆炸图片效果
    Image image1;
    Image image2;
    Image image3;

    public MyPanel(String key) throws IOException {
        nodes = Recorder.getNodes();
        //将MyPanel对象的enemyTanks赋给Recorder的enemyTanks
        Recorder.setEnemyTanks(enemyTanks);
        myTank = new MyTank(500, 200);
        myTank.setSpeed(6);
        //初始化敌人坦克
        switch (key) {
            case "1" -> {
                for (int i = 0; i < enemyTankSize; i++) {
                    //enemyTanks.add(new EnemyTank((int)(Math.random()*500), (int)(Math.random()*500)));
                    EnemyTank enemyTank = new EnemyTank((100 * (i + 1)), 0);
                    //将enemyTanks添加到enemyTank
                    enemyTank.setEnemyTanks(enemyTanks);
                    //启动敌人坦克线程
                    new Thread(enemyTank).start();
                    enemyTank.setDir(2);
                    //加入子弹
                    Shot shot = new Shot(enemyTank.getX() + 20, enemyTank.getY() + 60, enemyTank.getDir());
                    enemyTank.shots.add(shot);
                    //启动shot对象
                    new Thread(shot).start();
                    enemyTanks.add(enemyTank);
                }
            }
            case "2" -> {
                //nodes = Recorder.getNodes(); //新游戏重置击毁数量
                for (int i = 0; i < nodes.size(); i++) {
                    Node node = nodes.get(i);
                    EnemyTank enemyTank = new EnemyTank(node.getX(), node.getY());
                    //将enemyTanks添加到enemyTank
                    enemyTank.setEnemyTanks(enemyTanks);
                    //启动敌人坦克线程
                    new Thread(enemyTank).start();
                    enemyTank.setDir(node.getDir());
                    //加入子弹
                    Shot shot = new Shot(enemyTank.getX() + 20, enemyTank.getY() + 60, enemyTank.getDir());
                    enemyTank.shots.add(shot);
                    //启动shot对象
                    new Thread(shot).start();
                    enemyTanks.add(enemyTank);
                }
            }
            default -> {
                System.out.println("你的输入有误");
            }
        }

        //初始化图片对象
        image1 = Toolkit.getDefaultToolkit().getImage(MyPanel.class.getResource("/bomb1.png"));
        image2 = Toolkit.getDefaultToolkit().getImage(MyPanel.class.getResource("/bomb2.png"));
        image3 = Toolkit.getDefaultToolkit().getImage(MyPanel.class.getResource("/bomb3.png"));

    }

    //显示击毁数量
    public void showInfo(Graphics g) {
        //画出玩家总成绩
        g.setColor(Color.BLACK);
        Font font = new Font("宋体", Font.BOLD, 25);
        g.setFont(font);

        g.drawString("您累计击毁敌方坦克", 1020, 30);
        drawTank(1020, 60, g, 0, 0);
        g.setColor(Color.BLACK);
        g.drawString(String.valueOf(Recorder.getAllEnemyTankNum()), 1120, 100);
    }

    @Override
    public void paint(Graphics g) {
        super.paint(g);
        g.fillRect(0, 0, 1000, 800);
        showInfo(g);
        //画出我的坦克
        if (myTank != null && myTank.isLive) {
            drawTank(myTank.getX(), myTank.getY(), g, myTank.getDir(), 0);
        }
        //drawTank(myTank.getX() + 80, myTank.getY(), g, 0, 1);
        //如果bombs中对象，就画出
        try {
            Thread.sleep(50);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        for (int i = 0; i < bombs.size(); i++) {
            Bomb bomb = bombs.get(i);
            if (bomb.life > 6) {
                g.drawImage(image1, bomb.x, bomb.y, 60, 60, this);
            } else if (bomb.life > 3) {
                g.drawImage(image2, bomb.x, bomb.y, 60, 60, this);
            } else {
                g.drawImage(image3, bomb.x, bomb.y, 60, 60, this);
            }
            //生命值减少
            bomb.lifeDown();
            //如果life为0，则删去
            if (bomb.life == 0) {
                bombs.remove(bomb);
            }
        }
        //画出敌人坦克
        for (EnemyTank enemyTank : enemyTanks) {
            //首先判断当前坦克是否存活
            if (enemyTank.isLive) {
                drawTank(enemyTank.getX(), enemyTank.getY(), g, enemyTank.getDir(), 1);
                //绘制子弹
                for (int i = 0; i < enemyTank.shots.size(); i++) {
                    Shot shot = enemyTank.shots.get(i);
                    if (shot.isLive) {
                        g.draw3DRect(shot.x, shot.y, 2, 2, false);
                    } else {
                        //移除子弹
                        enemyTank.shots.remove(shot);
                    }
                }
            }
        }
        //画出我方射击的子弹
        for (int i = 0; i < myTank.shots.size(); i++) {
            Shot shot = myTank.shots.get(i);
            if (myTank.shot != null && shot.isLive) {
                g.draw3DRect(shot.x, shot.y, 2, 2, false);
            } else {
                //shot对象无效时应删去
                myTank.shots.remove(i);
            }
        }
    }
    //画坦克方法

    /**
     * @param x      坦克左上角x坐标
     * @param y      坦克左上角y坐标
     * @param g      画笔
     * @param direct 坦克方向上下左右
     * @param type   坦克类型
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
            case 2 -> { //向下
                g.fill3DRect(x, y, 10, 60, false);//左轮子
                g.fill3DRect(x + 30, y, 10, 60, false);//右轮子
                g.fill3DRect(x + 10, y + 10, 20, 40, false);//中间身体
                g.fillOval(x + 10, y + 20, 20, 20);//圆盖
                g.drawLine(x + 20, y + 30, x + 20, y + 60);//炮筒
            }
            case 3 -> { //向左
                g.fill3DRect(x, y, 60, 10, false);//左轮子
                g.fill3DRect(x, y + 30, 60, 10, false);//右轮子
                g.fill3DRect(x + 10, y + 10, 40, 20, false);//中间身体
                g.fillOval(x + 20, y + 10, 20, 20);//圆盖
                g.drawLine(x + 30, y + 20, x, y + 20);//炮筒
            }
            //default -> System.out.println("无");
        }
    }

    //遍历所有的子弹是否击中坦克
    public void hitEnemyTank() {
        //遍历我方子弹
        for (int i = 0; i < myTank.shots.size(); i++) {
            Shot shot = myTank.shots.get(i);
            //判断是否击中了敌人坦克
            if (shot != null && shot.isLive) { //当我的子弹还存活
                for (int j = 0; j < enemyTanks.size(); j++) { //遍历所有敌人坦克
                    EnemyTank enemyTank = enemyTanks.get(j);
                    //发射单个子弹
                    hitTank(shot, enemyTank);
                }
            }
        }
    }

    //判断敌方坦克是否击中我方
    public void hitMyTank() {
        //遍历敌方坦克
        for (int i = 0; i < enemyTanks.size(); i++) {
            //取出敌方坦克
            EnemyTank enemyTank = enemyTanks.get(i);
            //遍历enemyTank的所有子弹
            for (int j = 0; j < enemyTank.shots.size(); j++) {
                //取出子弹
                Shot shot = enemyTank.shots.get(j);
                //判断是否击中
                if (myTank.isLive && shot.isLive) {
                    hitTank(shot, myTank);
                }
            }
        }
    }

    //判断子弹是否击中
    public void hitTank(Shot s, Tank enemyTank) {
        //判断s 击中坦克
        switch (enemyTank.getDir()) { //坦克向上以及向下
            case 0, 2 -> {
                if (s.x > enemyTank.getX() && s.x < enemyTank.getX() + 40
                        && s.y > enemyTank.getY() && s.y < enemyTank.getY() + 60) {
                    s.isLive = false;
                    enemyTank.isLive = false;
                    enemyTanks.remove(enemyTank);
                    //当我方击毁敌方
                    if (enemyTank instanceof EnemyTank) {
                        Recorder.addAllEnemyTankNum();
                    }
                    //创建Bomb对象加入bombs集合中
                    Bomb bomb = new Bomb(enemyTank.getX(), enemyTank.getY());
                    bombs.add(bomb);
                }
            } //  坦克向左以及向右
            case 1, 3 -> {
                if (s.x > enemyTank.getX() && s.x < enemyTank.getX() + 60
                        && s.y > enemyTank.getY() && s.y < enemyTank.getY() + 40) {
                    s.isLive = false;
                    enemyTank.isLive = false;
                    enemyTanks.remove(enemyTank);
                    //当我方击毁敌方
                    if (enemyTank instanceof EnemyTank) {
                        Recorder.addAllEnemyTankNum();
                    }
                    Bomb bomb = new Bomb(enemyTank.getX(), enemyTank.getY());
                    bombs.add(bomb);
                }
            }
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
            myTank.setDir(3);
            myTank.moveLeft();
        } else if (e.getKeyCode() == KeyEvent.VK_S) {
            myTank.setDir(2);
            myTank.moveDown();
        }
        //射击子弹
        if (e.getKeyCode() == KeyEvent.VK_J) {
            //if (myTank.shot == null || ! myTank.shot.isLive) myTank.shotEnemy();
            //发射一颗子弹
            if (myTank != null && myTank.isLive) {
                myTank.shotEnemy();
            }
        }
        this.repaint();
    }

    @Override
    public void keyReleased(KeyEvent e) {

    }

    @Override
    public void run() { //重绘子弹
        while (true) {
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            //判断是否击中
            hitEnemyTank();
            hitMyTank();
            this.repaint();
        }
    }
}
