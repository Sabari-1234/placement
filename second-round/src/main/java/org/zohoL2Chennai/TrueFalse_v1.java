package org.zohoL2Chennai;

public class TrueFalse_v1 {
    public static void main(String[] args) {
        trueFalse("FTTTTFTFTF",2);
    }

    private static void trueFalse(String s,int k) {
        int left=0;
        int right=0;
        int count =0;
        int length=0;
        int max=0;
        while(right<s.length()){
            length++;
            if(s.charAt(right)=='F'){
                count++;
            }
            if(count>k){
                length--;
                if(length>max){
                    max=length;
                }
                while (s.charAt(left)=='T'){
                    left++;
                    length--;
                }
                left++;
                count--;
            }
            if(right==s.length()-1){
                if(length>max){
                    max=length;
                }

            }right++;

        }

        length=0;
        count=0;
        right=0;
        left=0;
        while(right<s.length()){
            length++;

            if(s.charAt(right)=='T'){
                count++;
            }
            if(count>k){
                length--;
                if(length>max){
                    max=length;
                }

                while (s.charAt(left)=='F'){
                    left++;
                    length--;
                }
                left++;

                count--;
            }
            if(right==s.length()-1){
                if(length>max){
                    max=length;
                }

            }right++;

        }
        System.out.println(max);
    }

}
