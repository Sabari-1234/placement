package org.zohoL2Chennai.validBrackets;

public class Stack {
    char[] arr;
    int top=0;
    public Stack(String para) {
        this.arr = new char[para.length()];
    }
    public void push(char val){
        arr[top]=val;
        top++;
    }
    public void pop(){
        top--;
    }
    public boolean isEmpty(){
        if(top==0){
            return true;
        }
        return false;
    }
    public char peek(){
        return arr[top-1];
    }
}
