package com.learn.QQ.QQClient.qqclient.view;

import com.learn.QQ.QQClient.qqclient.service.UserClientService;
import com.learn.QQ.QQClient.qqclient.utils.Utility;

/**
 * 客户端菜单界面
 */
public class QQView {
    private boolean loop = true; //控制是否显示菜单
    private String key = ""; //接收用户键盘输入
    private UserClientService userClientService = new UserClientService(); //用于登陆服务端

    public static void main(String[] args) {
        new QQView().mainMenu();
    }

    //显示主菜单
    private void mainMenu() {
        while (loop) {
            System.out.println("==============欢迎登陆网络通信系统==============");
            System.out.println("\t\t\t 1.登陆系统");
            System.out.println("\t\t\t 9.退出系统");

            key = Utility.readString(1);
            //根据用户输入，处理不通逻辑
            switch (key) {
                case "1" -> {
                    System.out.print("请输入用户号:");
                    String userId = Utility.readString(50);
                    System.out.print("请输入密码:");
                    String passwd = Utility.readString(50);
                    //服务端验证用户
                    if (userClientService.checkUser(userId, passwd)) {
                        System.out.println("==============欢迎" + userId + "==============");
                        //进入到二级菜单
                        while (loop) {
                            System.out.println("\n ==============网络通信系统二级菜单(用户:" + userId + ")==============");
                            System.out.println("\t\t\t 1.显示在线用户列表");
                            System.out.println("\t\t\t 2.群发消息");
                            System.out.println("\t\t\t 3.私聊消息");
                            System.out.println("\t\t\t 4.发送文件");
                            System.out.println("\t\t\t 9.退出系统");

                            key = Utility.readString(1);
                            switch (key) {
                                case "1" -> {
                                    System.out.println("显示在线用户列表");
                                }
                                case "2" -> {
                                    System.out.println("群发消息");
                                }
                                case "3" -> {
                                    System.out.println("私聊消息");
                                }
                                case "4" -> {
                                    System.out.println("发送文件");
                                }
                                case "9" -> {
                                    loop = false;
                                    System.out.println("退出系统");
                                }
                                default -> {
                                    System.out.println("输入有误");
                                }
                            }
                        }
                    }else { //登陆失败
                        System.out.println("==============登陆失败==============");
                    }
                }
                case "9" -> {
                    loop = false;
                    System.out.println("退出系统");
                }
                default -> {
                    System.out.println("输入有误");
                }
            }
        }
    }
}
