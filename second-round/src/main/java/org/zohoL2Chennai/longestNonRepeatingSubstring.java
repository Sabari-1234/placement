package org.zohoL2Chennai;

public class longestNonRepeatingSubstring {
    public static void main(String[] args) {
        String str="zohocorporation";
        longestSubstring(str);
    }

    private static void longestSubstring(String str) {
        String subString="";
        String res="";
        int j=0;
        for(int i=0;i<str.length();i++){

          if(stringContains(subString,str.charAt(i))){
              if(res.length()<subString.length())
                 res=subString;
              i=j++;
              subString=str.charAt(i)+"";
          }
          else{
              subString+=str.charAt(i)+"";
          }
        }
        System.out.println(res);
    }

    private static boolean stringContains(String subString,char charVal) {
        for(int i=0;i<subString.length();i++){
            if(subString.charAt(i)==charVal){
                return true;
            }
        }
        return false;

    }
}
