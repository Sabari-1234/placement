package org.zohoL2Chennai;

import java.util.ArrayList;

public class combinationSum3 {
    public static void main(String[] args) {
        int[] nums={1,2,3,4,5,6,7,8,9};
        int k=3;
        var res=new ArrayList<ArrayList<Integer>>();
        var cur=new ArrayList<Integer>();
        int index=0;
        int sum=0;
        int target=7;
        backTrack(nums,cur,res,index,k,target,sum);
        System.out.println(res);

    }
    public static void backTrack(int[] nums, ArrayList<Integer> cur,ArrayList<ArrayList<Integer>>res,int index,int k,int target,int sum) {
        if(cur.size()==k && sum==target){
            res.add(new ArrayList<>(cur));
            return;
        }
        if(index==nums.length || sum>target || cur.size()>k){
            return;
        }
        cur.add(nums[index]);
        sum+=nums[index];
        backTrack(nums,cur,res,index+1,k,target,sum);
        cur.remove(cur.size()-1);
        sum-=nums[index];
        backTrack(nums,cur,res,index+1,k,target,sum);

    }
}
