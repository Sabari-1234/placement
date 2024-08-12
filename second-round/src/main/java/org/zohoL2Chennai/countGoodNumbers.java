package org.zohoL2Chennai;

import java.util.ArrayList;

public class countGoodNumbers {
    static int count=0;
    public static void main(String[] args) {
        long n=50;
        int[] nums={1,2,3,4,5,6,7,8,9,0};
        ArrayList<Integer> cur=new ArrayList<>();
        int index=0;
        backTracking(n,cur,index,nums);
        System.out.println(count);
    }

    private static void backTracking(long n, ArrayList<Integer> cur, int index,int [] nums) {
        if(cur.size()==n){
            checkValid(cur);
            return;
        }
        for(int i=0;i< nums.length;i++){
            cur.add(nums[i]);
            backTracking(n,cur,index,nums);
            cur.remove(cur.size()-1);

        }
    }

    private static void checkValid(ArrayList<Integer> cur) {
        for(int i=0;i<cur.size();i++){
            if((i)%2==0){
                if(cur.get(i)%2!=0){
                    return;
                }
            }
            else{
                String str="2357";
                if(!str.contains(cur.get(i)+""))
                {
                   return;
                }
            }
        }
        count++;
        System.out.println(count);
    }

}
