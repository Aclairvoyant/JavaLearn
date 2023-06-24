package com.learn.TankGame03;

import javax.swing.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.IOException;
import java.util.Scanner;

public class TankGame03 extends JFrame {
    MyPanel mp;
    static Scanner scanner = new Scanner(System.in);
    public static void main(String[] args) throws IOException {
        new TankGame03();
    }
    public TankGame03() throws IOException {
        System.out.println("请输入选择 1：新游戏  2：继续游戏");
        String key = scanner.next();
        mp = new MyPanel(key);
        Thread thread = new Thread(mp);
        thread.start();

        this.add(mp);
        this.setSize(1300, 800);
        this.addKeyListener(mp);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setVisible(true);

        //在JFrame中添加相应关闭窗口的处理
        this.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                System.out.println("关闭游戏中");
                try {
                    Recorder.keepRecord();
                } catch (IOException ex) {
                    throw new RuntimeException(ex);
                }
                System.exit(0);
            }
        });
    }
}
