package org.StackLL;

public class Node {
    int data;
    Node next;
    public static Node head=null;
    public static int size=0;
    public Node(int data) {
        this.next = null;
        this.data = data;
    }

}
