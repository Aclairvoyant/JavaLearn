package com.learn.QQ.QQServer.qqcommon;

import java.io.Serial;
import java.io.Serializable;

/**
 * 表示客户端和服务端通信时的消息对象
 */
public class Message implements Serializable {
    @Serial
    private static final long serialVersionUID = 1L;
    private String sender; //发送方
    private String receiver; //接收方
    private String content; //内容
    private String sendTime; //发送时间
    private String mesType; //消息类型(可以在接口中定义消息类型)

    public Message(String sender, String receiver, String content, String sendTime, String mesType) {
        this.sender = sender;
        this.receiver = receiver;
        this.content = content;
        this.sendTime = sendTime;
        this.mesType = mesType;
    }

    public Message() {

    }

    public String getSender() {
        return sender;
    }

    public void setSender(String sender) {
        this.sender = sender;
    }

    public String getReceiver() {
        return receiver;
    }

    public void setReceiver(String receiver) {
        this.receiver = receiver;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getSendTime() {
        return sendTime;
    }

    public void setSendTime(String sendTime) {
        this.sendTime = sendTime;
    }

    public String getMesType() {
        return mesType;
    }

    public void setMesType(String mesType) {
        this.mesType = mesType;
    }
}
