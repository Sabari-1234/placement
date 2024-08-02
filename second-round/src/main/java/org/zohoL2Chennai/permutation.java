package org.zohoL2Chennai;

import java.util.ArrayList;
import java.util.Arrays;

public class permutation {

    public static void main(String[] args) {
        int[] nums = {1, 2, 3};
        boolean[] bool = new boolean[nums.length];
        int index = 0;
        var res = new ArrayList<ArrayList<Integer>>();
        var cur = new ArrayList<Integer>();
        backTrack2(nums, res, cur, bool);
        System.out.println(res);
    }

    private static void backTrack2(int[] nums, ArrayList<ArrayList<Integer>> res, ArrayList<Integer> cur, boolean[] bool) {
        if (cur.size() == nums.length) {
            res.add(new ArrayList<>(cur));
            return;
        }
        for(int i=0;i<nums.length;i++) {
            System.out.println(i);
            if (!bool[i]) {
                cur.add(nums[i]);
                bool[i] = true;
                backTrack2(nums,  res, cur, bool);
                bool[i] = false;
                cur.remove(cur.size() - 1);
            }
        }



}
}
