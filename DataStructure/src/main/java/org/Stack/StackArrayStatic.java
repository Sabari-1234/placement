package org.Stack;

import java.util.Arrays;
import java.util.Scanner;

import static org.Stack.StackArray.arr;
import static org.Stack.StackArray.top;

public class StackArrayStatic {
    public static void main(String[] args) {
        Scanner sc =new Scanner(System.in);
        while(true){
            System.out.println("1.push\n2.pop\n3.peek\n4.size");
            System.out.println("enter your choice:");
            int choice=sc.nextInt();
            switch (choice){
                case 1:
                    System.out.println("enter data:");
                    int data=sc.nextInt();
                    pushStack(data);
                    break;
                case 2:

                   popStack();
                   break;

                case 3:
                    peekStack();
                    break;
                case 4:
                    sizeStack();
                    break;
                case 5:
                    show();
                    break;
            }
        }
    }

    private static void show() {
        for(int i=0;i<top;i++){
            System.out.print(arr[i]+" ");
        }
    }

    private static void sizeStack() {
        System.out.println(top);
    }

    private static void peekStack() {
        if(top>0) {
            System.out.println(arr[top - 1]);
        }
        else{
            System.out.println("stack is empty");
        }
    }

    private static void popStack() {
        if(top>0) {
            int data = arr[top - 1];
            arr[--top] = 0;
            System.out.println( data);
        }
        else{
            System.out.println("stack under flow");
        }


    }

    private static void pushStack(int data) {
        if(top<arr.length) {
            arr[top] = data;
            top++;
            System.out.println("data added");
        }
        else{
            System.out.println("stack over flow");
        }

    }
}
