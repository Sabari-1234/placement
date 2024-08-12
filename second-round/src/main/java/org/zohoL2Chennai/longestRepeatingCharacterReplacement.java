package org.zohoL2Chennai;

public class longestRepeatingCharacterReplacement {
    public static void main(String[] args) {
        String s = "ABBB"; int k = 2;
        longestString(s,k);
    }

    private static void longestString(String s, int k) {
        int left=0;
        int right=0;
        int count=0;
        int max=0;
        int diffCharCount=0;
        while(right!=s.length()){
            if(s.charAt(left)!=s.charAt(right)){
                diffCharCount++;
            }
            if(diffCharCount==k+1){
                while (s.charAt(left)!=s.charAt(right) ){
                    left++;
                    count--;
                }

                diffCharCount--;
            }
            right++;
            count++;
            if(max<count){
                max=count;
            }
        }
//        left=s.length()-1;
//        right=s.length()-1;
//        count=0;
//
//        diffCharCount=0;
//        while(right>=0){
//            if(s.charAt(left)!=s.charAt(right)){
//                diffCharCount++;
//            }
//            if(diffCharCount==k+1){
//                while (s.charAt(left)!=s.charAt(right) ){
//                    left--;
//                    count--;
//                }
//                diffCharCount--;
//            }
//            right--;
//            count++;
//            if(max<count){
//                max=count;
//            }
//        }
        System.out.println(max);
    }


}
