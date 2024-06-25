package org.Queue;


import java.util.Scanner;

import static org.Queue.QueueArray.arr;

import static org.Queue.QueueArray.end;

public class QueueArrayStatic {
    public static void main(String[] args) {
        Scanner sc =new Scanner(System.in);
        while(true){
            System.out.println("1.push\n2.pop\n3.peek\n4.size\n5.show\n6.isEmpty\n7.isFull");
            System.out.println("enter your choice:");
            int choice=sc.nextInt();
            switch (choice){
                case 1:
                    System.out.println("enter data:");
                    int data=sc.nextInt();
                    push(data);//enqueue
                    break;
                case 2:

                   pop();//dequeue
                   break;

                case 3:
                    peek();//end
                    break;
                case 4:
                    size();
                    break;
                case 5:
                    show();
                    break;
                case 6:
                    isEmpty();
                    break;
                case 7:
                    isFull();
                    break;
            }
        }
    }

    private static void show() {
        for(int i=0;i<end;i++){
            System.out.print(arr[i]+" ");
        }
    }
    private static void isEmpty() {
        if(end==0){
            System.out.println("true");
        }
        else System.out.println("false");
    }
    private static void isFull() {
        if(end== arr.length){
            System.out.println("true");
        }
        else System.out.println("false");
    }
    private static void size() {
        System.out.println(end);
    }



    private static void peekStack() {
        if(end>0) {
            System.out.println(arr[end - 1]);
        }
        else{
            System.out.println("stack is empty");
        }
    }

    private static void pop() {
        if(end>0) {
            int removed =arr[0];
            for(int i=1;i<arr.length;i++){
                arr[i-1]=arr[i];
            }
            end--;
            System.out.println(removed);
        }
        else{
            System.out.println("queue under flow");
        }


    }
    private static void peek() {
        if(end>0) {
            System.out.println(arr[0]);
        }
        else{
            System.out.println("queue is empty");
        }
    }
    private static void push(int data) {
        if(end<arr.length) {
            arr[end] = data;
            end++;
            System.out.println("data added");
        }
        else{
            System.out.println("Queue over flow");
        }

    }
}
