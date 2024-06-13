package org.zohoL2Chennai;

import java.util.ArrayList;

public class triangleSum_v1 {
    public static void main(String[] args) {
        int arr[]=new int[]{
                1,2,3,4,5
        };
        triSum(arr);
    }

    private static void triSum(int arr[]) {
        var al1=new ArrayList<Integer>();
        for(int i=0;i<arr.length;i++){
            al1.add(arr[i]);
        }
        ArrayList<ArrayList<Integer>> res=new ArrayList<>();
        res.add(al1);
        while(res.get(res.size()-1).size()>1) {
            al1=new ArrayList<Integer>();
            for (int i = 0; i < res.get(res.size()-1).size() - 1; i++) {
                al1.add((res.get(res.size()-1).get(i)+res.get(res.size()-1).get(i+1))%10);

            }
            res.add(al1);

        }
        System.out.println(al1.get(0));
    }

}
