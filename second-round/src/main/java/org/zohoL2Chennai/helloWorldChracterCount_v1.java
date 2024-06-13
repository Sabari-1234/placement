package org.zohoL2Chennai;

public class helloWorldChracterCount_v1 {
    public static void main(String[] args) {
        minCount("hello am i using hello world is to u i hello");
    }

    private static void minCount(String s) {
        String[] arr=s.split(" ");
        int min=Integer.MAX_VALUE;
        for(int i=0;i< arr.length;i++){
            if(arr[i].equals("hello")){
                int j=i+1;
                while (j< arr.length && !arr[j].equals("world")){

                    if(arr[j].equals("hello")){
                        i=j;
                    }
                    j++;
                }

                if(j-i-1<min && j!=arr.length){
                    min=j-i-1;
                }
            }
        }


        for(int i=0;i< arr.length;i++){
            if(arr[i].equals("world")){
                int j=i+1;
                while (!arr[j].equals("hello") && j< arr.length){
                    if(arr[j].equals("world")){
                        i=j;
                    }
                    j++;
                }
                if(j!=arr.length && j-i-1<min){
                    min=j-i-1;
                }
            }
        }
        System.out.println(min);
    }
}
