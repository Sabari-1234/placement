package org.zohoL2Chennai;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class recursivePalindrome_v1 {
    public static void main(String[] args) {
     polindrome(1,"aababax");

    }

    private static void polindrome(int k,String str) {
       int j=str.length()-1;
       int i=0;
       int count=0;
      while(i<j){
           if(str.charAt(i)!=str.charAt(j-i)){
               if(count<k) {
                   count++;
                   System.out.print(count);
                   System.out.print(pl1(i, j - 1, str,count,k) || pl1(i+1, j, str,count,k));
                   return;
               }
               else System.out.print(false);
               return;

           }

           i++;
       }
        System.out.print(true);
    }

    private static boolean pl1(int i,int j,String str,int count,int k) {
        while(i<j){

            if(str.charAt(i)!=str.charAt(j-i)){
                if(count<k){
                    count++;
                   return pl1(i, j - 1, str,count,k) || pl1(i+1, j, str,count,k);
                }
                else return false;
            }
          i++;
        }
        return true;
    }

}