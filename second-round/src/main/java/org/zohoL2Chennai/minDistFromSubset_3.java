package org.zohoL2Chennai;

import java.util.ArrayList;
import java.util.Arrays;

public class minDistFromSubset_3 {

    public static void main(String[] args) {
        int[] arr = new int[]{5,10,15,20,25};
        mindist(arr);
    }

    private static void mindist(int[] arr) {

        //find sum
        int sum = 0;
        for (int i = 0; i < arr.length; i++) {
            sum += arr[i];

        }
        //get half
        int half = sum / 2;
        int[] val=new int[arr.length];
        int[] sumArr=new int[arr.length];
        int[] diff=new int[arr.length];
        int[] pre=new int[arr.length];

        val[0]=arr[arr.length-1];
        sumArr[0]=arr[arr.length-1];
        val[0]=arr[arr.length-1];
        diff[0]=Math.abs(arr[arr.length-1]-half);
        pre[0]=-1;
        int j=1;
        int prev=0;
        for(int i=arr.length-2;i>=0;i--){

            //val


            val[j]=arr[i];

            //sumArr
            if(sumArr[j-1]<half){
                sumArr[j]=sumArr[j-1]+val[j];
            }
            else{
                sumArr[j]=sumArr[pre[j-1]]+val[j];
            }

            //diff
            diff[j]=Math.abs(sumArr[j]-half);
            pre[j]=prev;

            //prev
            if(sumArr[j]<half){
                prev=j;
            }
            j++;
        }

        //find min in diff
        int smallDiff=Integer.MAX_VALUE;
        int smallDiffIndex=-1;
        for(int i=0;i<diff.length;i++){

            if(diff[i]<smallDiff){
                smallDiff=diff[i];
                smallDiffIndex=i;
            }

        }

//       var Result1=new ArrayList<Integer>();
//        var Result2=new ArrayList<Integer>();
        System.out.println("first array");
      var res1Index=new ArrayList<Integer>();
       while(smallDiffIndex!=-1){
//           Result1.add(val[smallDiffIndex]);


           System.out.println(val[smallDiffIndex]);
            res1Index.add(smallDiffIndex);
           smallDiffIndex=pre[smallDiffIndex];
       }
        System.out.println("second array");
       for(int i=0;i<val.length;i++){
           if(!res1Index.contains(i)){
               System.out.println(val[i]);
//               Result2.add(val[i]);
           }
       }



    }

}
