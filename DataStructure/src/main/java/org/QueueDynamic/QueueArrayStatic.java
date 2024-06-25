package org.QueueDynamic;


import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

import static org.QueueDynamic.QueueArray.*;

public class QueueArrayStatic {
public static void main(String[] args) {
    Queue<Integer> queue = new LinkedList<>();

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

            }
        }
    }

    private static void show() {
        for(int i=0;i<arr.length;i++){
            System.out.print(arr[i]+" ");
        }
    }
    private static void isEmpty() {
        if(end==0){
            System.out.println("true");
        }
        else System.out.println("false");
    }

    private static void size() {
        System.out.println(end);
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

        if(end>0 && end<=arr.length/4){
            shrink();
        }
        if(end==0) System.out.println("queue empty");





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
        if(end==arr.length) {
            expand();
        }

            arr[end] = data;
            end++;
            System.out.println("data added");



    }
    private static void expand(){
        size=size*2;
        int[] arr1=new int[size];
        for(int i=0;i<end;i++){
            System.out.println(i);
            arr1[i]=arr[i];
        }

        arr=arr1;
    }
    private static void shrink(){
        size=size/2;
        int[] arr1=new int[size];
        for(int i=0;i<end;i++){
            System.out.println(i);
            arr1[i]=arr[i];
        }

        arr=arr1;
    }

}
