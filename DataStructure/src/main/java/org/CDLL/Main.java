package org.CDLL;

import java.util.Scanner;

import static org.CDLL.Node.head;

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
            Node right=head.pre;
            Node left=head;

            do{

                int temp=left.data;
                left.data= right.data;
                right.data=temp;

                right=right.pre;
                left=left.next;
            }while (left!=right && right.next!=left);
            System.out.println("reversed successfully");
        }
    }

    private static void deletePosDLL(int pos) {
        if(head==null){
            System.out.println("no data found");
        }
        else if (pos==1) {
            deleteBeginDLL();

        } else{
            int index=1;
            Node temp=head;
           do{
                temp=temp.next;
                index++;
            } while (temp.next!=head && index!=pos);
            if(temp.next==head && index!=pos){
                System.out.println("specified index not found");
            } else if (temp.next==head && index==pos) {
               deleteEndDLL();
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
        }else if(head.next==head){
            head=null;
            System.out.println("deleted successfully");
        }else{
            Node slow=head;
            Node fast=head;
         do{
                slow=slow.next;
                fast=fast.next.next;
            }   while (fast!=head && fast.next!=head);
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
        }else if(head.next==head){
            head=null;
            System.out.println("deleted successfully");
        }else{
            Node newHead=head.next;
            newHead.pre=head.pre;
            head.pre.next=newHead;
            head=newHead;
//            head=head.next;
//            head.pre=null;
            System.out.println("deleted successfully");
        }
    }

    private static void deleteEndDLL() {
        if(head==null){
            System.out.println("no data found");
        }else if(head.next==head){
            head=null;
            System.out.println("deleted successfully");
        }
        else{
//            Node temp=head;
//            while(temp.next!=null){
//                temp=temp.next;
//            }
//            temp=temp.pre;
//            temp.next=null;

            Node newEnd=head.pre.pre;
            head.pre=newEnd;
            newEnd.next=head;
            System.out.println("deleted successfully");
        }
    }

    private static void insertMidDLL(int data) {
        Node newNode=new Node(data);
        if(head==null){
            head=newNode;
            head.next=head;
            head.pre=head;
        } else if (head.next==head) {
            head.next=newNode;
            head.pre=newNode;

        } else{
            Node slow=head;
            Node speed=head;
            do{
                slow= slow.next;
                speed=speed.next.next;
            }while(speed!=head && speed.next!=head);
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
                head.next=head;
                head.pre=head;
            }
            else{
                System.out.println("no pos available");
            }
        } else if (pos==1) {
            insertBeginDLL(data);
        } else{
            int index=1;
            Node temp=head;

            do{
                temp=temp.next;
                index++;
            }while(index!=pos && temp!=head);

            if(temp==head && pos!=index){
                System.out.println("specified pos not available");
            } else if (temp==head && pos==index) {
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
            head.next=head;
            head.pre=head;
        }else{
            newNode.pre=head.pre;
            head.pre=newNode;
            head=newNode;
            newNode.pre.next=newNode;

        }
        System.out.println("data added at begin successfully");
    }

    private static void printDLL() {
        if(head==null){
            System.out.println("no data found");
        }
        else{
            Node temp =head;
           do{
                System.out.println(temp.data);
                temp=temp.next;
            } while(temp!=head);
        }
    }

    private static void insertEndDLL(int data) {
        Node newNode=new Node(data);
        if(head==null){
            head=newNode;
            head.next=head;
            head.pre=head;
        }else {

            Node last=head.pre;
            last.next=newNode;
            newNode.pre=last;

            head.pre=newNode;

        }
        System.out.println("data added successfully");
    }
}
