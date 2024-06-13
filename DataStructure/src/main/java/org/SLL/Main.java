package org.SLL;
import java.util.Scanner;
import static org.SLL.Node.head;
public class Main {
    public static void main(String[] args) {
        while(true){
            System.out.println("1.InsertEnd\n2.Print\n3.InsertBegin\n4.PosInsert\n5.InsertMiddle\n6.DeleteEnd\n7.deleteBegin\n8.deletePos\n9.deleteMid\n10.reverseLL");
            Scanner sc=new Scanner(System.in);
            int choice=sc.nextInt();
            switch (choice){
                case 1:
                    System.out.println("enter data of node:");
                    int data=sc.nextInt();
                    insertEnd(data);
                    break;
                case 2:
                    printLL();
                    break;
                case 3:
                    System.out.println("enter data of node:");
                    data=sc.nextInt();
                    insertBegin(data);
                    break;
                case 4:
                    System.out.println("enter data of node:");
                    data=sc.nextInt();
                    System.out.println("enter position");
                    int pos=sc.nextInt();
                    insertPos(data,pos);
                    break;
                case 5:
                    System.out.println("enter data of node:");
                    data=sc.nextInt();
                    insertMiddle(data);
                    break;
                case 6:
                    deleteEnd();
                    break;
                case 7:
                    deleteBegin();
                    break;
                case 8:
                    System.out.println("enter position");
                    pos=sc.nextInt();
                    deletePos(pos);
                    break;
                case 9:
                    deleteMiddle();
                    break;
                case 10:
                    reverseLL();
                    break;
                default:
                    System.out.println(" enter a valid input");
                    break;
            }
        }
    }

    private static void reverseLL() {
        if(head==null){
            System.out.println("no element found");

        }
        else if (head.next==null) {
            System.out.println("only one element need no reverse functionality");
        } else{
            Node temp1=head.next;
            if(temp1.next==null){
                temp1.next=head;
                head.next=null;
                head=temp1;
            }else{
                Node temp2=temp1.next;
                head.next=null;
                while(temp2.next!=null){
                    temp1.next=head;
                    head=temp1;
                    temp1=temp2;
                    temp2=temp2.next;
                }
                temp1.next=head;
                temp2.next=temp1;
                head=temp2;
            }
        }
    }

    private static void deleteMiddle() {
        if(head==null){
            System.out.println("no node found");
        } else if (head.next==null) {
            head=null;
        } else{
            Node slow=head;
            Node deletePre=head;
            Node speed=head;
            while ( speed!=null&&speed.next!=null){
                deletePre=slow;
                slow=slow.next;
                speed=speed.next.next;
            }
            deletePre.next=slow.next;
        }
    }

    private static void deletePos(int pos) {
        if(head==null){
            System.out.println("no node found");
        } else if (pos==1) {
            head=head.next;
        } else{
            Node curr=head;
            Node pre=head;
            int i=1;
            while( curr!=null&&i!=pos){
                pre=curr;
                curr=curr.next;
                i++;
            }
            if(curr==null){
                System.out.println("no position");
            }
            else {
                pre.next=curr.next;
            }

        }
    }
    private static void deleteBegin() {
        if(head==null){
            System.out.println("no node found");
        }
        else{
            head=head.next;
        }
    }

    private static void deleteEnd() {
        if(head==null){
            System.out.println("no node found");
        }
        else{
            Node curr=head;
            Node pre=head;
            while (curr.next!=null){
                pre=curr;
                curr=curr.next;
            }
            pre.next=null;
        }
    }
    private static void insertMiddle(int data) {
        if(head==null){
            head=new Node(data);
        }else {
            Node newNode=new Node(data);
            Node slow=head;
            Node MidPre=head;
            Node speed=head;
            while(speed!=null && speed.next!=null){
                MidPre=slow;
                slow=slow.next;
                speed=speed.next.next;

            }
            newNode.next=MidPre.next;
            MidPre.next=newNode;
        }
    }

    private static void insertPos(int data,int pos) {
        if(head==null){
            head=new Node(data);
        } else if (pos==1) {
            insertBegin(data);
        }
        else {
            Node newNode=new Node(data);
            Node temp=head;
            int i=1;
            while(pos-1!=i && temp!=null){
                temp=temp.next;
                i++;
            }
            newNode.next=temp.next;
            temp.next=newNode;
        }

    }

    private static void insertBegin(int i) {
        if(head==null){
            head=new Node(i);
        }
        else{
            Node newNode=new Node(i);
            newNode.next=head;
            head=newNode;
        }
    }

    private static void printLL() {
        Node node =head;
        if(head==null){
            System.out.println("empty");
        }
        while(node!=null){
            System.out.println(node.data);
            node=node.next;
        }
    }

    private static void insertEnd(int i) {

        if(head==null){
            head=new Node(i);
        }
        else{
            Node newNode=new Node(i);
            Node temp=head;
            while (temp.next!=null){
                temp=temp.next;
            }
            temp.next=newNode;
        }
    }
}
