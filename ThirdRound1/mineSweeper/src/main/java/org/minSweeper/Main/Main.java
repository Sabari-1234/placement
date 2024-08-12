package org.minSweeper.Main;

import java.util.*;

public class Main {
    static int length=10;
    static int[][] board=new int[length][length];
    static char[][] boardShow=new char[length][length];
    static Scanner sc=new Scanner(System.in);
    static  int remainFlag=15;
    public static void main(String[] args) {

        Stack<ArrayList<Integer>> st=new Stack<>() ;

        var al=new ArrayList<Integer>();
        var bomb=new ArrayList<Integer>();
        Random random=new Random();
        while (st.size()<remainFlag){
            al.add(random.nextInt(length));
            al.add(random.nextInt(length));
            if(!st.contains(al))
                st.add(new ArrayList<>(al));
            al=new ArrayList<Integer>();
        }
        System.out.println(st);
        while (!st.isEmpty()){
            bomb=st.pop();
            board[bomb.get(0)][bomb.get(1)]=-1;
        }
        printBoard();
        System.out.println("-------------------------------------");
        fixNumber();
        printBoardShow();
        while (true) {
            System.out.println("1.dick\n2.flag");
            System.out.println("enter your choice:");
            int choice=sc.nextInt();
            switch (choice){
                case 1:
                    dick();
                    break;
                case 2:
                    flag();
                    break;
            }
            printBoardShow();
            if(remainFlag==0)
                isWin();
        }

}

    private static void isWin() {
        for(int i=0;i<boardShow.length;i++){
            for(int j=0;j<boardShow[0].length;j++){
                if(boardShow[i][j]==(char)0){
                    return;
                }
            }
        }
        System.out.println("you won the game");
        System.exit(0);
    }

    private static void flag() {
        System.out.println("row:");
        int row =sc.nextInt();
        System.out.println("col:");
        int col=sc.nextInt();
        if(boardShow[row][col]=='F'){
            boardShow[row][col]=(char) 0;
            remainFlag++;
        }
        else{
            if(remainFlag!=0) {
                boardShow[row][col]='F';
                remainFlag--;

            }
            else {
                System.out.println("no remaining flags");
            }
        }

    }

    private static void dick() {
        System.out.println("row:");
        int row =sc.nextInt();
        System.out.println("col:");
        int col=sc.nextInt();
        if(boardShow[row][col]!='F') {
            if (board[row][col] != -1 && board[row][col] != 0) {
                boardShow[row][col] = (char) (board[row][col] + '0');
            } else if (board[row][col] ==0) {
                openForZero(row,col);
            } else {
                System.out.println("game over");
                System.exit(0);
            }

        }

    }

//    private static void openForZero(int row,int col) {
//        boardShow[row][col] = (char) (board[row][col] + '0');
//            if (row + 1 < boardShow.length) {
//                boardShow[row + 1][col] = (char) (board[row + 1][col] + '0');
//                if( board[row + 1][col]==0){
//                    openForZero(row+1,col);
//                }
//
//            }
//            if (col + 1 < boardShow[0].length) {
//                boardShow[row][col + 1] = (char) ( board[row][col + 1]  + '0');
//                if( board[row ][col+1]==0){
//                    openForZero(row,col+1);
//                }
//
//            }
//            if (row - 1 >= 0 ) {
//                if( board[row -1][col]==0){
//                    openForZero(row-1,col);
//                }
//                boardShow[row - 1][col] = (char) ( board[row - 1][col] + '0');
//            }
//            if (col - 1 >= 0) {
//                if( board[row][col-1]==0){
//                    openForZero(row,col-1);
//                }
//                boardShow[row][col - 1] = (char) (board[row][col - 1] + '0');
//            }
//            if (row + 1 < boardShow.length && col + 1 < boardShow[0].length ) {
//                if( board[row + 1][col+1]==0){
//                    openForZero(row+1,col+1);
//                }
//                boardShow[row + 1][col + 1] = (char) (board[row + 1][col + 1] + '0');
//            }
//            if (row - 1 >= 00 && col - 1 >= 0 ) {
//                if( board[row -1][col-1]==0){
//                    openForZero(row-1,col-1);
//                }
//                boardShow[row - 1][col - 1] = (char) (board[row - 1][col - 1] + '0');
//            }
//            if (row + 1 < boardShow.length && col - 1 >= 0 ) {
//                if( board[row + 1][col-1]==0){
//                    openForZero(row+1,col-1);
//                }
//                boardShow[row + 1][col - 1] = (char) ( board[row + 1][col - 1]  + '0');
//            }
//            if (row - 1 >= 0 && col + 1 < boardShow[0].length) {
//                if( board[row -1][col+1]==0){
//                    openForZero(row-1,col+1);
//                }
//                boardShow[row - 1][col + 1] = (char) (board[row - 1][col + 1]  + '0');
//            }
//        return;
//    }
private static void openForZero(int row, int col) {
    // Base cases: out of bounds or already processed (i.e., not zero anymore)
    if (row < 0 || row >= boardShow.length || col < 0 || col >= boardShow[0].length || board[row][col] == -1) {
        return;
    }

    // Process the current cell and mark it as proceremainFlags:14ssed
    boardShow[row][col] = (char) (board[row][col] + '0');
    if (board[row][col] == 0) {
        // Mark as processed by setting to a special value (e.g., -1)
        board[row][col] = -1;

        // Recursively open surrounding cells
        openForZero(row + 1, col);     // Down
        openForZero(row - 1, col);     // Up
        openForZero(row, col + 1);     // Right
        openForZero(row, col - 1);     // Left
        openForZero(row + 1, col + 1); // Down-right
        openForZero(row - 1, col - 1); // Up-left
        openForZero(row + 1, col - 1); // Down-left
        openForZero(row - 1, col + 1); // Up-right
    }
}

    private static void printBoardShow() {
        for(int i=0;i<boardShow.length;i++)
            System.out.println(Arrays.toString(boardShow[i]));
        System.out.println("remainFlags:"+remainFlag);
    }

    private static void fixNumber() {
        for(int i=0;i<board.length;i++){
            for(int j=0;j<board[0].length;j++){
                if(board[i][j]==-1){
                    if(i+1<board.length && board[i+1][j]!=-1){
                        board[i+1][j]+=1;
                    }
                    if(j+1<board[0].length &&  board[i][j+1]!=-1){
                        board[i][j+1]+=1;
                    }
                    if(i-1>=0 &&  board[i-1][j]!=-1){
                        board[i-1][j]+=1;
                    }
                    if(j-1>=0 && board[i][j-1]!=-1){
                        board[i][j-1]+=1;
                    }
                    if(i+1<board.length&&j+1<board[0].length &&  board[i+1][j+1]!=-1){
                        board[i+1][j+1]+=1;
                    }
                    if(i-1>=00&&j-1>=0 &&board[i-1][j-1]!=-1){
                        board[i-1][j-1]+=1;
                    }
                    if(i+1<board.length&&j-1>=0 &&   board[i+1][j-1]!=-1){
                        board[i+1][j-1]+=1;
                    }
                    if(i-1>=0&&j+1<board[0].length &&  board[i-1][j+1] !=-1){
                        board[i-1][j+1]+=1;
                    }
                }
            }
        }
        printBoard();
    }

    private static void printBoard() {
        for(int i=0;i<board.length;i++)
            System.out.println(Arrays.toString(board[i]));
        System.out.println("----------------------------");
    }
}
