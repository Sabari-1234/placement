package org.zohoL2Chennai;

import java.util.HashMap;
import java.util.Map;

public class maxGuest {
    public static void main(String[] args) {
        int arr1[]=new int[]{1,2,9,5,5};
        int arr2[]=new int[]{4,5,12,9,12};
        maxguest(arr1,arr2);
    }

    private static void maxguest(int arr1[],int arr2[]) {
        var map=new HashMap<Integer,Integer>();
        int i=0;
        while(i<arr1.length) {
            for (int j= arr1[i]; j<=arr2[i]; j++){
                map.put(j,map.getOrDefault(j,0)+1);
            }
            i++;
        }
        int max=0;
        int maxEle=0;
        for(Map.Entry<Integer,Integer> entry:map.entrySet()){
            if(entry.getValue()>max){
                max=entry.getValue();
                maxEle=entry.getKey();
            }
        }
        System.out.println(maxEle);
    }
}
