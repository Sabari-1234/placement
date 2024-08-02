package org.zohoL2Chennai;

public class characterChange {
    public static void main(String[] args) {
        String str="Hel12650";
        stringChange(str);
    }

    private static void stringChange(String str) {
        String res="";
        String num="6566676869797172737475767778798081828384858687888990";
        for(int i=0;i<str.length();i++){
            if(i<str.length()-2 && num.contains(str.substring(i,i+2))){
                res+=(char)Integer.parseInt(str.substring(i,i+2))+"";
                i++;
            }
            else if(str.length()>0 && str.charAt(i)=='+'){
                res+=str.charAt(i-1);
            } else if (str.length()>1 && str.charAt(i)=='*') {
                res+=str.charAt(i-2);
            }
            else{
                res+=str.charAt(i);
            }
        }
        System.out.println(res);
    }
}
