package com.learn.List_;

public class LinkedList01 {
    public static void main(String[] args) {
        Node jack = new Node("jack");
        Node tom = new Node("tom");
        Node ches = new Node("ches");

        jack.next = tom;
        tom.next = ches;

        ches.pre = tom;
        tom.pre = jack;

        Node first = jack;
        Node last = ches;

        //遍历
        while (first != null) {
            System.out.println(first);
            first = first.next;
        }
    }
}

class Node {
    public Object item;
    public Node pre;
    public Node next;

    public Node(Object name) {
        this.item = name;
    }

    @Override
    public String toString() {
        return "Node{" +
                "item=" + item +
                '}';
    }
}
