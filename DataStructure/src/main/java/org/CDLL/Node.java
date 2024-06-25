package org.CDLL;

public class Node {
    int data;
    Node next;
    Node pre;
    public static Node head;
    public Node(int data) {
        this.data = data;
        this.next = head;
        this.pre = head;
    }
}
