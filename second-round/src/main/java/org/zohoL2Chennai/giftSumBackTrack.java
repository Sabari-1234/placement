package org.zohoL2Chennai;
import java.util.ArrayList;
public class giftSumBackTrack {
    public static void main(String[] args) {
        int[] num={4,1,2};
        int max=0;
        for(int i=0;i<num.length;i++){
            if(num[i]>max){
                max=num[i];
            }
        }
        int[] nums =new int[max];
        for(int i=1;i<=max;i++){
            nums[i-1]=i;
        }
        var res = new ArrayList<ArrayList<Integer>>();
        var cur = new ArrayList<Integer>();
        backTrack2(nums, res, cur,num);
        for(int i=0;i<res.size();i++){
            char let='A';
            for(int j=0;j<res.get(0).size();j++){
                System.out.print(let+""+res.get(i).get(j)+" ");
                let++;
            }
            System.out.println();
        }
    }
    private static void backTrack2(int[] nums, ArrayList<ArrayList<Integer>> res, ArrayList<Integer> cur,int[] num) {
        if (cur.size() == nums.length-1) {
            checkAdd(cur,res,num);
            return;
        }
        for(int i=0;i<nums.length;i++) {
                cur.add(nums[i]);
                backTrack2(nums,  res, cur,num);
                cur.remove(cur.size() - 1);
        }
    }
    private static void checkAdd(ArrayList<Integer> cur,ArrayList<ArrayList<Integer>> res,int[] num) {
        for(int i=0;i<num.length;i++){
            if(num[i]<cur.get(i)){
                return;
            }
        }
        res.add(new ArrayList<>(cur));
    }
}
