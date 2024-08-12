package org.zohoL2Chennai;

public class myAtoi {
    public static void main(String[] args) {
        String s="-42";
        s=s.trim();
        int index=0;
        int num=0;
        num=backTrack9(s,index,num);
        if(s.charAt(0)=='-'){
            num*=-1;
        }
        System.out.println(num);
    }

    private static int backTrack9(String s,int index,int num) {

        if(index==s.length() || ((s.charAt(index)-'0')<0 || (s.charAt(index)-'0')>9) && (s.charAt(index)!='-') ) {

            return num;
        }
        if(s.charAt(index)!='-'){
            num=num*10+(s.charAt(index)-'0');
        }
        return backTrack9(s,index+1,num);
    }

}
