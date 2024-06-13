package org.zohoL2Chennai;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class recursivePalindrome_v2 {
    public static void main(String[] args) {
     polindrome(2,"aaabadx");

    }

    private static void polindrome(int k,String str) {
       int j=str.length()-1;
       int i=0;

      while(i<j){
           if(str.charAt(i)!=str.charAt(j)){

               if(k>0) {
                   System.out.println(k);
                   k--;

                   System.out.print(pl1(i, j - 1, str,k) || pl1(i+1, j, str,k));

                   return;
               }
               else System.out.print(false);
               return;

           }

           i++;
           j--;
       }
        System.out.print(true);
    }

    private static boolean pl1(int i,int j,String str,int k) {
        System.out.println(i+" "+(j));
        while(i<j){

            if(str.charAt(i)!=str.charAt(j)){ System.out.println(i+" "+(j));

                if(k>0){
                    System.out.println(k);
                   k--;
                   return pl1(i, j - 1, str,k) || pl1(i+1, j, str,k);
                }

                    return false;

            }
          i++;
            j--;
        }
        return true;
    }

}