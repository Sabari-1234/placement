package org.zohoL2Chennai;

import java.util.ArrayList;

public class divisorGame_v1 {
    public static void main(String[] args) {
        int n=6;
        var res=new ArrayList<Integer>();
        res.add(n);
        for(int i=n-1;i>0;i--){
            if(n%i==0){
                res.add(i);

                i=n-i;
                n=n-i;
            }
        }
        if(res.size()%2==0) System.out.println(true);
        System.out.println(false);
    }
}
