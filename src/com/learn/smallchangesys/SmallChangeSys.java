package com.learn.smallchangesys;

import java.util.Scanner;

public class SmallChangeSys {
    public static void main(String[] args) {
        boolean loop = true;
        Scanner sc = new Scanner(System.in);
        String key = "";

        do {
            System.out.println("========零钱通菜单========");
            System.out.println(" 1.零钱通明细");
            System.out.println(" 2.收益入账");
            System.out.println(" 3.消费");
            System.out.println(" 4.退出");

            System.out.print("请选择(1-4):");
            key = sc.next();

            switch (key) {
                case "1":
                    System.out.println("1.零钱通明细");
                    break;
                case "2":
                    System.out.println("2.收益入账");
                    break;
                case "3":
                    System.out.println("3.消费");
                    break;
                case "4":
                    System.out.println("4.退出");
                    loop = false;
                    break;
                default:
                    System.out.println("输入有误");
            }

        } while (loop);
        System.out.println("已退出");
    }
}
