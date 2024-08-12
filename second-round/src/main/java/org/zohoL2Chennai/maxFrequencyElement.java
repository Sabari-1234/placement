package org.zohoL2Chennai;

import java.util.Arrays;
import java.util.HashMap;

public class maxFrequencyElement {
    static int max=0;
    public static void main(String[] args) {
        int[] nums={1,4,8,13};
        int k=5;
        int index=0;
        int count=0;
        maxFre(nums,k,index,count);
        int max1=max;
        max=0;
        System.out.println(max1);
    }

    private static void maxFre(int[] nums, int k,int index,int count) {
        if(index==nums.length){
            return;
        }
        if(count<=k){
            checkForFrequency(nums);
            System.out.println(Arrays.toString(nums));

        }
        if(count==k){
            return;
        }

        nums[index]+=1;
        count++;
        maxFre(nums,k,index, count);
        nums[index]-=1;
        count--;
        index++;
        maxFre(nums,k,index,count);
    }

    private static void checkForFrequency(int[] nums) {
        HashMap<Integer,Integer> map=new HashMap<>();
        for(int i=0;i< nums.length;i++){
            map.put(nums[i],map.getOrDefault(nums[i],0)+1);
        }

        for(Integer key:map.keySet()){
            if(max<map.get(key)){
                max=map.get(key);
            }
        }
    }
}
