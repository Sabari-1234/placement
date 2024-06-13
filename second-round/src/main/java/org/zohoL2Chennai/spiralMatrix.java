package org.zohoL2Chennai;

public class spiralMatrix {
    public static void main(String[] args) {
        int mat[][]=new int[][]{
                {1,2,3},
                {4,5,6},
                {7,8,9}
        };
        spiral(mat);
    }

    private static void spiral(int mat[][]) {


        int i=0,j=0;
        while (true){

            if(j<mat[0].length-1 && i==0) {
                System.out.println(mat[i][j]);
                j++;
            }
            else if(j==mat[0].length-1 && i<mat.length-1){
                System.out.println(mat[i][j]);
                i++;
            }
            else if(j==mat[0].length-1 && i==mat.length-1 && j!=0){
                System.out.println(mat[i][j]);
                j--;
//                System.out.println(i );
//                System.out.println(j );
          }
            //else if{
//                System.out.println(mat[i][j]);
//                i--;
//                break;
//            }
//            else{
//                System.out.println(mat[i][j]);
//                j++;
//            }

        }
    }
}
