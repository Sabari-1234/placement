package org.zohoL2Chennai;

public class maxConsecutiveOnes {
    public static void main(String[] args) {
        int[]nums = {0,0,1,1,0,0,1,1,1,0,1,1,0,0,0,1,1,1,1};int k = 3;
        maxOnes(nums,k);
    }

    private static void maxOnes(int[] nums, int k) {
        int left=0;
        int right=0;
        int count=0;
        int zeroCount=0;
        int max=0;
        while(right!=nums.length){

            if(nums[right]==0){
                zeroCount++;
            }
            if(zeroCount==k+1){
                while(nums[left]!=0){
                    left++;
                    count--;
                }
                left++;
                zeroCount--;
                count--;
            }
            right++;
            count++;
            if(count>max){
                max=count;
            }


        }
        System.out.println(max);

    }


}
