package org.zohoL2Chennai;

public class maxCostPath {
    static int max=Integer.MIN_VALUE;
    public static void main(String[] args) {
        int[][] mat={{1,2,3},{4,5,6},{7,8,9}};
        maxCost(mat);
    }
    private static void maxCost(int [][] mat) {
        recFindSum(0,0,0,mat);
        System.out.println(max);
    }
    private static void recFindSum(int row,int col,int sum,int[][]mat) {
        if(row>mat.length-1 || col>mat[0].length-1){
            return;
        }
        sum+=mat[row][col];
        if(row==mat.length-1 && col==mat[0].length-1){
            if(max<sum){
                max=sum;
            }
        }
        recFindSum(row+1,col,sum,mat);
        recFindSum(row,col+1,sum,mat);
    }
}
