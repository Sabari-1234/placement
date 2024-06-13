package org.DLL;

import java.util.Scanner;

import static org.DLL.Node.head;

public class Main {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        while (true){
            System.out.println("1.insertEnd\n2.print\n3.insertBegin\n4.InsertPos\n5.InsertMid\n6.deleteEnd\n7.deleteBegin\n8.deleteMid\n9.deletePos\n10.reverse");
            int choice =sc.nextInt();
            switch (choice){
                case 1:
                    System.out.println("Enter a data to add");
                    int data= sc.nextInt();
                    insertEndDLL(data);
                    break;
                case 2:
                    System.out.println("data are:");
                    printDLL();
                    break;
                case 3:
                    System.out.println("Enter a data to add");
                    data= sc.nextInt();
                    insertBeginDLL(data);
                    break;
                case 4:
                    System.out.println("Enter a data to add ");
                    data= sc.nextInt();
                    System.out.println("Enter a position");
                    int pos=sc.nextInt();
                    insertPosDLL(data,pos);
                    break;
                case 5:
                    System.out.println("Enter a data to add ");
                    data= sc.nextInt();
                    insertMidDLL(data);
                    break;
                case 6:
                    deleteEndDLL();
                    break;
                case 7:
                    deleteBeginDLL();
                    break;
                case 8:
                    deleteMidDLL();
                    break;
                case 9:

                    System.out.println("Enter a position");
                    pos=sc.nextInt();
                    deletePosDLL(pos);
                    break;
                case 10:
                    reverseDLL();
                    break;
            }
        }
    }

    private static void reverseDLL() {
        if(head==null){
            System.out.println("no data found");
        }
        else{
            Node right=head;
            Node left=head;
            while(right.next!=null){
                right=right.next;
            }
            while (left!=right && right.next!=left){

                int temp=left.data;
                left.data= right.data;
                right.data=temp;

                right=right.pre;
                left=left.next;
            }
            System.out.println("reversed successfully");
        }
    }

    private static void deletePosDLL(int pos) {
        if(head==null){
            System.out.println("no data found");
        }
        else if (pos==1) {
            if(head.next==null ){
                head=null;
                System.out.println("deleted successfully");
            }
            else{
                head=head.next;
                head.pre=null;
                System.out.println("deleted successfully");
            }

        } else{
            int index=1;
            Node temp=head;
            while (temp.next!=null && index!=pos){
                temp=temp.next;
                index++;
            }
            if(temp.next==null && index!=pos){
                System.out.println("specified index not found");
            } else if (temp.next==null && index==pos) {
                Node prev=temp.pre;

                prev.next=null;
                System.out.println("deleted successfully");
            }
            else {
                Node prev = temp.pre;
                Node aft = temp.next;
                prev.next = aft;
                aft.pre = prev;
                System.out.println("deleted successfully");
            }
        }
    }

    private static void deleteMidDLL() {
        if(head==null){
            System.out.println("no data found");
        }else if(head.next==null){
            head=null;
            System.out.println("deleted successfully");
        }else{
            Node slow=head;
            Node fast=head;
            while (fast!=null && fast.next!=null){
                slow=slow.next;
                fast=fast.next.next;
            }
            Node prev=slow.pre;
            Node aft=slow.next;
            prev.next=aft;
            aft.pre=prev;
            System.out.println("deleted successfully");
        }
    }

    private static void deleteBeginDLL() {

        if(head==null){
            System.out.println("no data found");
        }else if(head.next==null){
            head=null;
            System.out.println("deleted successfully");
        }else{
            head=head.next;
            head.pre=null;
            System.out.println("deleted successfully");
        }
    }

    private static void deleteEndDLL() {
        if(head==null){
            System.out.println("no data found");
        }else if(head.next==null){
            head=null;
            System.out.println("deleted successfully");
        }
        else{
            Node temp=head;
            while(temp.next!=null){
                temp=temp.next;
            }
            temp=temp.pre;
            temp.next=null;
            System.out.println("deleted successfully");
        }
    }

    private static void insertMidDLL(int data) {
        Node newNode=new Node(data);
        if(head==null){
            head=newNode;
        } else if (head.next==null) {
            head.next=newNode;
            newNode.pre=head;
        } else{
            Node slow=head;
            Node speed=head;
            while(speed!=null && speed.next!=null){
                slow= slow.next;
                speed=speed.next.next;
            }
            Node prev=slow.pre;
            prev.next=newNode;
            newNode.pre=prev;
            newNode.next=slow;
            slow.pre=newNode;
        }
        System.out.println("inserted successfully");
    }

    private static void insertPosDLL(int data,int pos) {
        Node newNode=new Node(data);
        if(head==null){
            if(pos==1){
                head=newNode;
            }
            else{
                System.out.println("no pos available");
            }
        } else if (pos==1) {
            insertBeginDLL(data);
        } else{
            int index=1;
            Node temp=head;

            while(index!=pos && temp!=null){
                temp=temp.next;
                index++;
            }
            System.out.println(pos);
            System.out.println(index);
            if(temp==null && pos!=index){
                System.out.println("specified pos not available");
            } else if (temp==null && pos==index) {
                insertEndDLL(data);
            }
            else{
                Node prev=temp.pre;
                prev.next=newNode;
                newNode.pre=prev;
                newNode.next=temp;
                temp.pre=newNode;
            }
        }
        System.out.println("data added successfully in given position");
    }

    private static void insertBeginDLL(int data) {
        Node newNode=new Node(data);
        if(head==null){
            head=newNode;
        }else{
            newNode.next=head;
            head.pre=newNode;
            head=newNode;
        }
        System.out.println("data added at begin successfully");
    }

    private static void printDLL() {
        if(head==null){
            System.out.println("no data found");
        }
        else{
            Node temp =head;
            while(temp!=null){
                System.out.println(temp.data);
                temp=temp.next;
            }
        }
    }

    private static void insertEndDLL(int data) {
        Node newNode=new Node(data);
        if(head==null){
            head=newNode;
        }else {

            Node temp=head;
            while(temp.next!=null){
                temp=temp.next;
            }
            temp.next=newNode;
            newNode.pre=temp;
        }
        System.out.println("data added successfully");
    }
}
