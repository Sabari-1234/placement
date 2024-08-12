package org.zohoL2Chennai;

import java.util.ArrayList;
import java.util.List;

public class permutation2 {
    public static void main(String[] args) {
        int[] nums={1,1,2};
        boolean[] bool=new boolean[nums.length];
        var cur=new ArrayList<Integer>();
        List<List<Integer>> res=new ArrayList<>();

        backTrack4(nums,cur,res,bool);
        System.out.println(res);
    }

    private static void backTrack4(int[] nums, ArrayList<Integer> cur, List<List<Integer>> res,boolean[] bool) {
        if(cur.size()==nums.length){

            if(!res.contains(cur))
                res.add(new ArrayList<>(cur));
            return;
        }
        for(int i=0;i<nums.length;i++){
            if(!bool[i]) {
                cur.add(nums[i]);
                bool[i] = true;
                backTrack4(nums, cur, res, bool);
                cur.remove(cur.size() - 1);
                bool[i] = false;
            }
        }
    }


}
