package org.StackLL;

import java.util.Scanner;

import static org.StackLL.Node.head;
import static org.StackLL.Node.size;

public class Main {
    public static void main(String[] args) {
        while(true){
            System.out.println("1.peek\n2.show\n3.push\n4.pop\n5.size");
            Scanner sc=new Scanner(System.in);
            int choice=sc.nextInt();
            switch (choice){
                case 1 :
                    peek();
                    break;
                case 2:
                    show();
                    break;
                case 3:
                    System.out.println("enter data of node:");
                    int data=sc.nextInt();
                    push(data);
                    break;

                case 4:
                    pop();
                    break;
                case 5:
                    size();
                    break;


                default:
                    System.out.println(" enter a valid input");
                    break;
            }
        }
    }
    private  static void size(){
        System.out.println(size);
    }
    private static void peek() {
        if(head==null){
            System.out.println("stack is empty");
        }
        else{
            System.out.println(head.data);
        }
    }

    private static void pop() {
        if(head==null){
            System.out.println("no node found");
        }
        else{
            System.out.println(head.data);
            head=head.next;
            size--;
        }
    }
    private static void push(int i) {
        if(head==null){
            head=new Node(i);
        }
        else{
            Node newNode=new Node(i);
            newNode.next=head;
            head=newNode;
        }
        size++;
    }

    private static void show() {
        Node node =head;
        if(head==null){
            System.out.println("empty");
        }
        while(node!=null){
            System.out.println(node.data);
            node=node.next;
        }
    }


}
