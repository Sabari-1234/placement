package org.zohoL2Chennai.LLSumRecursion;

import java.util.Scanner;

import static org.zohoL2Chennai.LLSumRecursion.Node.head2;
import static org.zohoL2Chennai.LLSumRecursion.Node.head1;

public class LLSumRecursion {
    static Scanner sc=new Scanner(System.in);
    public static void main(String[] args) {
        boolean flag=true;
        while(flag) {
            System.out.println("1.1st list add\n2.2nd list add");
            int choice=sc.nextInt();
            switch (choice){
                case 1:
                    System.out.println("enter data for 1st list");
                    int data = sc.nextInt();
                    insertEnd(data, head1);
                case 2:
                    System.out.println("enter data for 1st list");
                     data = sc.nextInt();
                    insertEnd(data, head2);
                default:
                   flag=false;
            }

        }

        int carry=addingTwoList(head1,head2);
        if(carry!=0) {
            Node newNode=new Node(carry);
            newNode.next=head1;
            head1=newNode;
        }
        Node temp=head1;
        while(temp!=null){
            System.out.println(temp.data);
            temp=temp.next;
        }
    }

    private static int addingTwoList(Node head1,Node head2) {
        if((head1.next==null && head2.next==null)){
            int data= head1.data+ head2.data;
            int carry=0;
            if((int)Math.log10(data)==2){

               carry=data/10;
                data=data%10;

            }
            head1.data=data;
            return carry;
        }
        int carry=addingTwoList(head1.next,head2.next);
        int data= head1.data+ head2.data+carry;
        carry=0;
        if((int)Math.log10(data)==2){

            carry=data/10;
            data=data%10;

        }
        head1.data=data;
        return carry;


    }

    private static void insertEnd(int data,Node head) {
        Node newNode=new Node(data);
        if(head==null){
            head=newNode;

        }
        else{
            Node temp=head;
            while(temp.next!=null){
                temp=temp.next;
            }
            temp.next=newNode;
        }

    }


}
