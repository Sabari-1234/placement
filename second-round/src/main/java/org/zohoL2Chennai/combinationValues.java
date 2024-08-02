package org.zohoL2Chennai;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class combinationValues {
    public static void main(String[] args) {
        int n=4;
        int k=2;
        int[] nums=new int[n];
        for(int i=0;i<n;i++){
            nums[i]=i+1;
        }
        System.out.println(Arrays.toString(nums));
        ArrayList<Integer> cur=new ArrayList<>();
        List<List<Integer>> res=new ArrayList<>();
        int index=0;
        backTrack3(nums,k,res,cur,index);
        System.out.println(res);
    }

    private static void backTrack3(int[] nums,int k,List<List<Integer>> res,ArrayList<Integer> cur,int index) {

        if(cur.size()==k){
            System.out.println(cur);
            res.add(new ArrayList<>(cur));
            return;
        }
        if(index==nums.length){
            return;
        }
        cur.add(nums[index]);
        backTrack3(nums,k,res,cur,index+1);
        cur.remove(cur.size()-1);
        backTrack3(nums,k,res,cur,index+1);
    }
}
