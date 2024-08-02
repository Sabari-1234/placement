package org.zohoL2Chennai;

import java.util.ArrayList;
import java.util.List;

public class permutation2 {
    public static void main(String[] args) {
        int[] nums={1,1,2};
        var cur=new ArrayList<Integer>();
        List<List<Integer>> res=new ArrayList<>();

        backTrack4(nums,cur,res);
    }

    private static void backTrack4(int[] nums, ArrayList<Integer> cur, List<List<Integer>> res) {
        for(int i=0;i<nums.length;i++){
            cur.add(nums[i]);
            backTrack4();
        }
    }


}
