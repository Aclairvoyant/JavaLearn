package com.learn.Draw_;

import javax.swing.*;
import java.awt.*;

public class drawCircle extends JFrame{
    private MyPanel mp;
    public static void main(String[] args) {
        new drawCircle();
    }
    public drawCircle() {
        mp = new MyPanel();
        this.add(mp);
        this.setSize(3000, 2000);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setVisible(true);
    }
}

class MyPanel extends JPanel {
    @Override
    public void paint(Graphics g) {
        super.paint(g);
        //g.drawOval(100, 100, 1000, 1000);//圆形
        g.drawLine(100, 100, 1000, 1000 );
        g.drawRect(100, 100, 1000,1000);

    }
}
