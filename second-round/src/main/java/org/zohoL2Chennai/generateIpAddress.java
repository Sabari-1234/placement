package org.zohoL2Chennai;

import java.util.ArrayList;
import java.util.Arrays;

public class generateIpAddress {

    public static void main(String[] args) {
        int[] nums = {1, 2, 3,4,5};
        String str="101023";
        boolean[] bool = new boolean[nums.length];

        var res = new ArrayList<String>();
        var cur = new ArrayList<Integer>();
        backTrack2(nums, res, cur, bool,str);
       System.out.println(res);
    }

    private static void backTrack2(int[] nums, ArrayList<String> res, ArrayList<Integer> cur, boolean[] bool,String str) {
        if (cur.size() == nums.length) {

            StringBuilder sb=new StringBuilder(str);
            int index=1;
            for(int i=0;i<cur.size();i++){
                if(cur.get(i)==1 || cur.get(i)==2 || cur.get(i)==3){
                    sb.insert(i+index,'.');
                    index++;
                }

            }

            addRes(sb.toString(),res);

            return;
        }
        for(int i=0;i<nums.length;i++) {

            if (!bool[i]) {
                cur.add(nums[i]);
                bool[i] = true;
                backTrack2(nums,  res, cur, bool,str);
                bool[i] = false;
                cur.remove(cur.size() - 1);
            }
        }



    }

    private static void addRes(String string,ArrayList<String> res) {
        String resStr=string;
        String sub="";
        if(!res.contains(string)){
            for(int i=0;i<3;i++){
                sub=string.substring(0,string.indexOf('.'));
                string=string.substring(string.indexOf('.')+1,string.length());
                if(Integer.parseInt(sub)>255 || (sub.charAt(0)-'0'==0 && sub.length()>1)){
                    return;
                }
            }
            if(Integer.parseInt(string)>255 || (string.charAt(0)-'0'==0 && string.length()>1))
                return;
            res.add(resStr);
        }
    }
}
