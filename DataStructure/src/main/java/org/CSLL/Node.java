package org.CSLL;

public class Node {
    int data;
    Node next;
    public static Node head=null;
    public Node(int data) {
        this.next = head;
        this.data = data;
    }

}
