package org.zohoL2Chennai;

import java.util.ArrayList;

public class combination {
    public static void main(String[] args) {
        int[] nums={2,3,6,7};
        var res=new ArrayList<ArrayList<Integer>>();
        var cur=new ArrayList<Integer>();
        int target=7;
        int index=0;
        int sum=0;
        backTrack1(nums,target,index,res,cur,sum);
        System.out.println(res);
    }

    private static void backTrack1(int [] nums,int target,int index,ArrayList<ArrayList<Integer>> res,ArrayList<Integer>cur,int sum) {
        if(sum>target || index==nums.length) return;
        if(sum==target){

            res.add(new ArrayList<>(cur));
            return;
        }

        cur.add(nums[index]);
        sum+=nums[index];
        backTrack1(nums,target,index,res,cur,sum);
        sum-=nums[index];
        cur.remove(cur.size()-1);
        index++;
        backTrack1(nums,target,index,res,cur,sum);
    }
}
