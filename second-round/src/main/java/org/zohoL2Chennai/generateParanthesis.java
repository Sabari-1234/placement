package org.zohoL2Chennai;


import java.util.ArrayList;
import java.util.Stack;

public class generateParanthesis {
    static int index=0;
    static ArrayList<String> al=new ArrayList<>();
    public static void main(String[] args) {
        int n=3;
        String curr="";
        backTrack(curr,n);
        System.out.println(al);
    }

    private static void backTrack(String curr, int n) {
        if(curr.length()==2*n ){
            if(validParanthesis(curr))
                al.add(curr);
            return;
        }
        backTrack(curr+"(",n);
        backTrack(curr+")",n);


    }

    private static boolean validParanthesis(String para) {
        Stack<Character> st=new Stack<>();

            for(int i=0;i<para.length();i++){
                if(para.charAt(i)=='(' || para.charAt(i)=='{' || para.charAt(i)=='['){
                    st.push(para.charAt(i));
                }
                else if (!st.isEmpty() && (para.charAt(i)==')' && st.peek()=='(') || (para.charAt(i)==']' && st.peek()=='[') || (para.charAt(i)=='}' && st.peek()=='{')){
                    st.pop();
                }
                else{
                    return false;
                }
            }
            if(st.isEmpty()){
                return true;
            }
            return false;

    }
}
