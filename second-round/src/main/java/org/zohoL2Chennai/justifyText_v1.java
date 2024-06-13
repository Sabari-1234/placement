package org.zohoL2Chennai;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;

public class justifyText_v1 {
    public static void main(String[] args) {
        justify("hel in the cell",12);
    }

    private static void justify(String s,int k) {
        int spaceIndex=0;
        int count=0;
        for(int i=0;i<s.length();i++){
            count++;
            if(s.charAt(i)==' '){
                spaceIndex=i;
            }
            if(i==s.length()-1 && count<=k){
                String sub=s.substring(i-count+1,s.length());
                while (sub.length()!=k){
                    sub+=" ";
                }
                System.out.println("'"+sub+"'");
            }
            if(count>k){
                StringBuilder sb=new StringBuilder();
                sb.append(s.substring(i-k,spaceIndex));
                int len=sb.length();
                var spaceList=new HashMap<Integer,Integer>();
                int m=0;
                for (int j=0;j<sb.length();j++){
                    if(sb.charAt(j)==' '){
                        spaceList.put(m,j);
                        m++;

                    }
                }


                int j=0;
                if(sb.indexOf(" ")!=-1){
                    while (len!=k){
                        if(j==spaceList.size()) j=0;

                        sb.insert(spaceList.get(j)," ");
                        for(int l=0;l<spaceList.size();l++){
                           spaceList.put(l,spaceList.get(l)+1);
//
                        }
                        j++;
                        len=sb.length();
                    }
                    spaceList.clear();
                    System.out.println("'"+sb.toString()+"'");
                }
                else{
                    while (sb.length()!=k){
                        sb.append(" ");
                    }
                    System.out.println("'"+sb.toString()+"'");
                }
                i=spaceIndex;

                count=0;
            }
        }
    }
}
