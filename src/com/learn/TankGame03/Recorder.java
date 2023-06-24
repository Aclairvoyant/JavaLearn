package com.learn.TankGame03;

import java.io.*;
import java.util.Vector;

//用于记录相关信息，与文件交互
public class Recorder {
    //记录我方击毁敌人数量
    private static int allEnemyTankNum = 0;
    //定义IO对象
    //private static FileWriter fw = null;
    private static BufferedWriter bw = null;
    private static BufferedReader br = null;
    private static String recordFile = "src/myRecord.txt";
    //定义vector指向敌人坦克
    private static Vector<EnemyTank> enemyTanks = null;
    //定义一个Node的Vector，保存敌人信息的Node
    private static Vector<Node> nodes = new Vector<>();

    @Override
    public String toString() {
        return super.toString();
    }

    public static void setEnemyTanks(Vector<EnemyTank> enemyTanks) {
        Recorder.enemyTanks = enemyTanks;
    }
    //读取文件，恢复游戏数据
    public static Vector<Node> getNodes() throws IOException {
        try {
            br = new BufferedReader(new FileReader(recordFile));
            allEnemyTankNum = Integer.parseInt(br.readLine());
            //循环读取文件,生成nodes集合
            String line = "";
            while ((line = br.readLine()) != null) {
                String[] s = line.split(" "); //xyd
                Node node = new Node(Integer.parseInt(s[0]), Integer.parseInt(s[1]), Integer.parseInt(s[2]));
                nodes.add(node);//封装到Vector中
                //System.out.println(node);
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        } finally {
            if (br != null) {
                br.close();
            }
        }
        return nodes;
    }

    //当游戏退出时，保存文件
    public static void keepRecord() throws IOException {
        try {
            bw = new BufferedWriter(new FileWriter(recordFile));
            bw.write(String.valueOf(allEnemyTankNum));
            bw.newLine();
            //遍历敌人坦克Vector
            for (int i = 0; i < enemyTanks.size(); i++) {
                EnemyTank enemyTank = enemyTanks.get(i);
                if (enemyTank.isLive) {
                    //保存该enemyTank的信息
                    String record = enemyTank.getX() + " " + enemyTank.getY() + " " + enemyTank.getDir();
                    bw.write(record);
                    bw.newLine();
                }
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        } finally {
            if (bw != null) {
                bw.close();
            }
        }
    }

    public static int getAllEnemyTankNum() {
        return allEnemyTankNum;
    }

    public static void setAllEnemyTankNum(int allEnemyTankNum) {
        Recorder.allEnemyTankNum = allEnemyTankNum;
    }

    public static void addAllEnemyTankNum() {
        Recorder.allEnemyTankNum ++;
    }
}
