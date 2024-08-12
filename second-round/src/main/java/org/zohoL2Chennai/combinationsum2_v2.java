package org.zohoL2Chennai;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class combinationsum2_v2 {
    public static void main(String[] args) {
        int[] nums={10,1,2,7,6,1,5};
        Arrays.sort(nums);
        var cur=new ArrayList<Integer>();
        List<List<Integer>> res=new ArrayList<>();
        int index=0;
        int sum=0;
        int target=8;
        backTrack5(nums,cur,res,index,sum,target);
        System.out.println(res);
    }

    private static void backTrack5(int[] nums, ArrayList<Integer> cur, List<List<Integer>> res, int index,int sum,int target) {
        if(sum==target){
            System.out.println(cur);

            if(!res.contains(cur))
                res.add(new ArrayList<>(cur));
            return;
        }
        if(index==nums.length){
            return;
        }
        cur.add(nums[index]);
        sum+=nums[index];
        backTrack5(nums,cur,res,index+1,sum,target);
        cur.remove(cur.size()-1);
        sum-=nums[index];
        backTrack5(nums,cur,res,index+1,sum,target);
    }
}
