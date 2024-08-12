package org.zohoL2Chennai;

public class wordSearch {
    static boolean ans=false;
    public static void main(String[] args) {
        String res="";
        char[][]board = {{'a','b'}};
        boolean[][] bool=new boolean[board.length][board[0].length];
        String word = "ba";
        int row=0;
        int col=0;
        int index=0;
        for(int i= 0;i<board.length;i++){
            for(int j=0;j<board[0].length;j++){
                if(ans){
                    System.out.println(true);
                    return;
                }
                backTrack6(res,word,board,i,j,bool,index);
                bool=new boolean[board.length][board[0].length];
            }
        }

        System.out.println(ans);
    }

    private static void backTrack6(String res, String word, char[][] board, int row, int col,boolean[][] bool,int index) {
        if(res.contains(word)){
//            System.out.println(true);
            ans=true;
            return;
        }
        if(row==board.length || row<0 || col==board[0].length || col<0){
            System.out.println(res);
            return;
        }
        if(!bool[row][col]) {
            res += board[row][col];
            bool[row][col] = true;
            backTrack6(res, word, board, row + 1, col, bool, index);
            backTrack6(res, word, board, row, col + 1, bool, index);
            backTrack6(res, word, board, row - 1, col, bool, index);
            backTrack6(res, word, board, row, col - 1, bool, index);
            bool[row][col] = false;
        }
    }


}
