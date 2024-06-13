package org.zohoL2Chennai;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class minDistFromSubset_v1 {
    public static void main(String[] args) {
        int[] arr = new int[]{5,25,100,150,200};
        min(arr);
    }

    private static void min(int[] arr) {
        int sum =0;
        for (int i=0;i<arr.length;i++){
            sum+=arr[i];
        }



           int max = sum / 2 ;


         List<Integer> al1 = new ArrayList<>();
        List<Integer> al2 = new ArrayList<>();

        al1.add(arr[arr.length-1]);
        al2.add(arr[arr.length-1]);

       int mindis=Integer.MAX_VALUE;
       int s=al1.get(0);
        for(int j=arr.length-2;j>=0;j--){
            if(max-al1.get(0)==0){

                break;
            }

           s+=arr[j];

            if(max==s){
                if(al1.size()==2){
                    al1.remove(1);
                }

                al1.add(arr[j]);
                break;
            }

            if(max<s){
//                if(al2.size()>1){
//
//                    al1.remove(al1.size()-1);
//
//                    al1.add(arr[j]);
//
//                }

                    if(al1.size()>1){
                        al1.remove(al1.size()-1);
                    }
                    al1.add(arr[j]);



                    s=al1.get(0);
                }


            if(max>s){


                al2.add(arr[j]);
            }
//           if(mindis>Math.abs(max-s)){
//               if(al1.size()==2){
//                   al1.remove(1);
//               }
//               mindis=Math.abs(max-s);
//               al1.add(arr[j]);
//           }




        }
        for (int i=0;i<al1.size();i++){

            System.out.println(String.valueOf(al1.get(i)));

        }
        System.out.println("222");
        for (int i=0;i<al1.size();i++){


            System.out.println(String.valueOf(al2.get(i)));
        }
    }

}
