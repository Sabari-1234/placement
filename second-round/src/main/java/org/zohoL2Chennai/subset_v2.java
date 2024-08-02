package org.zohoL2Chennai;

import java.util.ArrayList;

public class subset_v2 {
    public static void main(String[] args) {
        int[] nums={1,2,3};
        var res=new ArrayList<ArrayList<Integer>>();
        var cur=new ArrayList<Integer>();
        int index=0;

        backTrack(nums,cur,res,index);
        System.out.println(res);

    }
    public static void backTrack(int[] nums, ArrayList<Integer> cur,ArrayList<ArrayList<Integer>>res,int index) {

        if(index==nums.length){

            res.add(new ArrayList<>(cur));

            return;
        }
        cur.add(nums[index]);
        backTrack(nums,cur,res,index+1);
        cur.remove(cur.size()-1);
        backTrack(nums,cur,res,index+1);

    }
}
