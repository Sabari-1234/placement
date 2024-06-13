package org.zohoL2Chennai;

import java.util.Arrays;

public class replaceWithNextGreatestElement_V1 {
    public static void main(String[] args) {
        int[] arr=new int[]{16, 17, 4, 3, 1, 2};
        nextGreatEle(arr);
    }

    private static void nextGreatEle(int[] arr) {
        int index=0;
        int max=-1;
        for(int i=0;i<arr.length;i++){
            if(i==index){
                max=-1;
                for(int j=i+1;j<arr.length;j++){
                    if(arr[j]>max){
                        max=arr[j];
                        index=j;
                    }
                }
            }
            arr[i]=max;

        }arr[arr.length-1]=-1;
        System.out.println(Arrays.toString(arr));
    }


}
