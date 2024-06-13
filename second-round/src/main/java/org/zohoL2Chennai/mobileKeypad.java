package org.zohoL2Chennai;

import java.util.HashMap;

public class mobileKeypad {
    public static void main(String[] args) {
        String input="9999666446660222666777_7";
        findCode(input);
    }

    private static void findCode(String input) {

        var map=new HashMap<Character,String>();
        map.put('2',"ABC");
        map.put('3',"DEF");
        map.put('4',"GHI");
        map.put('5',"JKL");
        map.put('6',"MNO");
        map.put('7',"PQRS");
        map.put('8',"TUV");
        map.put('9',"WXYZ");
        map.put('0'," ");
        map.put('_',"");

        int count =1;
        String s="";
        for(int i=1;i<input.length();i++){
            if(input.charAt(i)==input.charAt(i-1)){
                count++;
            }
            else{
                if(map.get(input.charAt(i-1)).length()!=0)
                   s+= map.get(input.charAt(i-1)).charAt((count-1)%map.get(input.charAt(i-1)).length());
                else
                    s+="";
               count=1;
            }

        }
        s+= map.get(input.charAt(input.length()-1)).charAt((count-1)%map.get(input.charAt(input.length()-1)).length());

        System.out.println(s);

    }
}
