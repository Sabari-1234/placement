package org.zohoL2Chennai;

import java.util.ArrayList;

public class generateAllBinary {
    public static void main(String[] args) {
        ArrayList<Integer>cur =new ArrayList<>();
        ArrayList<ArrayList<Integer>> res=new ArrayList<>();
        int[] nums={0,1};
        int k=4;
        backTracking1(nums,cur,res,k);
    }

    private static void backTracking1(int[] nums, ArrayList<Integer> cur, ArrayList<ArrayList<Integer>> res,int k) {
        if(cur.size()==k){
            for(int i=1;i<cur.size();i++){
                if(cur.get(i)==1 && cur.get(i-1)==1) return;
            }
            System.out.println(cur);
            return;
        }
        for(int i=0;i<nums.length;i++){
            cur.add(nums[i]);
            backTracking1(nums,cur,res,k);
            cur.remove(cur.size()-1);
        }
    }


}
