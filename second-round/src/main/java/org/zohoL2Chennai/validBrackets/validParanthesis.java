package org.zohoL2Chennai.validBrackets;

//import java.util.Stack;

public class validParanthesis {
    public static void main(String[] args) {
        String para="({[]})";
        System.out.println(validParan(para));
    }

    private static boolean validParan(String para) {
//        Stack<Character> st=new Stack<>();
        Stack st=new Stack(para);
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
