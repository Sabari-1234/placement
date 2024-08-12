package org.zohoL2Chennai;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class combinationSum2 {
    public static void main(String[] args) {
        int[] nums={10,1,2,7,6,1,5};
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
            addCheck(cur,res);
//            res.add(new ArrayList<>(cur));
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

    private static void addCheck(ArrayList<Integer>cur, List<List<Integer>> res) {
        ArrayList list1=new ArrayList<>(cur);
        Collections.sort(list1);
        for(int i=0;i<res.size();i++){
            ArrayList list2=new ArrayList<>(res.get(i));
            Collections.sort(list2);
            if(list1.equals(list2)){
                return;
            }

        }
        res.add(new ArrayList<>(cur));
    }


}
