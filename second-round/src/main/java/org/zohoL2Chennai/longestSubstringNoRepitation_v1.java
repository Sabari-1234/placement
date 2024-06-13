package org.zohoL2Chennai;

import java.util.ArrayList;
import java.util.List;

public class longestSubstringNoRepitation_v1 {
    public static void main(String[] args) {
      subString("zohocorporation");

    }

    private static void subString(String s) {
        var al=new ArrayList<String>();
        int i=0,j=0;
        int len=0;
        StringBuilder sb=new StringBuilder("");
        while(j<=s.length()-1){
            if(!sb.toString().contains(s.charAt(j)+"")){
                sb.append(s.charAt(j));
                j++;
            }
            else{

                if(al.isEmpty()) {
                    al.add(sb.toString());
                    len=sb.toString().length();
                }
                else if( sb.toString().length()>len){
                    al.clear();
                    al.add(sb.toString());
                    len= sb.toString().length();
                }
                else if( sb.toString().length()==len){
                    al.add(sb.toString());
                }


                sb.deleteCharAt(i);
//                System.out.println(i);
//                System.out.println(sb.toString());
//
            }
            if(j==s.length()-1  || j==s.length()){
                if(al.isEmpty()) {
                    al.add(sb.toString());
                    len=sb.toString().length();
                }
                else if( sb.toString().length()>len){
                    al.clear();
                    al.add(sb.toString());
                    len= sb.toString().length();
                }
                else if( sb.toString().length()==len){
                    al.add(sb.toString());
                }
            }
        }
        for(String arl:al){
            System.out.println(arl);
        }

    }
}
