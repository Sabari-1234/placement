package org.zohoL2Chennai;

public class stictlyIncreasing {
    public static void main(String[] args) {
        int[] arr={1,2,3,4,6,7,5};
        boolean ans=strictIncrease(arr);
        System.out.println(ans);
    }

    private static boolean strictIncrease(int[] arr) {
        for(int i=1;i<arr.length;i++){
            if(arr[i]<arr[i-1]){
                return false;
            }
        }
        return true;
    }
}
