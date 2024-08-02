package org.zohoL2Chennai;

public class maximumSubArrKadenalgo {
    public static void main(String[] args) {
        int [] arr={9,2,-9,0,9};
        mxSubArr(arr);
    }

    private static void mxSubArr(int[] arr) {
        int sum=0;
        int max=0;
       for(int i=0;i<arr.length;i++){
           sum+=arr[i];
           if(sum>max){
               max=sum;
           }
           if(sum<0){
               sum=0;
           }
       }
        System.out.println(max);
    }
}
