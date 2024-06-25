package org.game;

import java.util.Scanner;

public class Main {
    public  static  char[][] board=new char[][]{{' ',' ',' '},{' ',' ',' '},{' ',' ',' '}};
    public  static char playerSymbol;
    public  static char computerSymbol;
    public static  Scanner sc=new Scanner(System.in);
    public static void main(String[] args) {
        //geting symbols
        System.out.println("enter your symbol(X orO)");

        char symbol=Character.toUpperCase(sc.next().charAt(0));
        playerSymbol=symbol;
        if(symbol=='X'){
            computerSymbol='O';

        }
        else{
            computerSymbol='X';
        }
        printBoard();
        while(true){
            player();
            printBoard();
            if(matchEnd())
            {
                break;
            }
            computer();
            printBoard();
            if(matchEnd())
            {
                break;
            }
        }




    }

    private static void printBoard() {
        for(int i=0;i<board.length;i++){
            for(int j=0;j<board[0].length;j++){
                System.out.print(board[i][j]);
                System.out.print('|');
            }
            System.out.print('\n');
        }
    }

    private static boolean matchEnd() {
        if(Win(playerSymbol)){
            System.out.println("player win");
            return true;
        }

        if(Win(computerSymbol)){
            System.out.println("computer win");
            return true;
        }

        for(int i=0;i<board.length;i++){
            for(int j=0;j<board[0].length;j++){
                if(board[i][j]==' '){
                    return false;
                }
            }
        }
        System.out.println("match draw");
        return true;
    }



    private static boolean Win(char symb) {
        for(int i=0;i<board.length;i++){
           if(board[i][0]==symb && board[i][1]==symb && board[i][2]==symb){
               return true;
           }
        }
        for(int i=0;i<board.length;i++){
            if(board[0][i]==symb && board[1][i]==symb && board[2][i]==symb){
                return true;
            }
        }
        if(board[0][0]==symb && board[1][1]==symb && board[2][2]==symb){
            return true;
        }
        if(board[2][0]==symb && board[1][1]==symb && board[0][2]==symb){
            return true;
        }
        return false;
    }

    private static void computer() {
//        System.out.println("player 2");
//        System.out.println("enter row:");
//        int row=sc.nextInt()-1;
//        System.out.println("enter col:");
//        int col=sc.nextInt()-1;
//        if(board[row][col]==' '){
//            board[row][col]=computerSymbol;
//        }
//        else{
//            System.out.println("enter a valid position");
//            computer();
//        }
        int[] bestMove=new int[2];
        bestMove=minmax(computerSymbol);
        board[bestMove[0]][bestMove[1]]=computerSymbol;
    }

    private static int[] minmax(char currentSymbol) {
        int[]bestMove=new int[2];
        int bestScore= currentSymbol==computerSymbol? Integer.MIN_VALUE:Integer.MAX_VALUE;
        for(int i=0;i<board.length;i++){
            for(int j=0;j<board[0].length;j++){
                if(board[i][j]==' '){
                    board[i][j]=currentSymbol;
                    int score=minmaxScore(currentSymbol==computerSymbol?playerSymbol:computerSymbol);
                    board[i][j]=' ';
                    if(currentSymbol==computerSymbol){
                        if(score>bestScore){
                            bestMove=new int[]{i,j};
                            bestScore=score;
                        }

                    }
                    else{
                        if(score<bestScore){
                            bestMove=new int[]{i,j};
                            bestScore=score;
                        }
                    }
                }
            }
        }
        return bestMove;
    }

    private static int minmaxScore(char currentSymbol) {
        if(Win(currentSymbol)){
            if(currentSymbol==playerSymbol){
                return -1;
            }
            else{
                return 1;
            }
        }
        boolean isBoardFull = true;
        for(int i=0;i<board.length;i++){
            for(int j=0;j<board[0].length;j++){
                if(board[i][j]==' '){
                    isBoardFull = false;
                    break;
                }
            }
        }
        if(isBoardFull){
            return 0;
        }
        int bestScore= currentSymbol==computerSymbol? Integer.MIN_VALUE:Integer.MAX_VALUE;

        for(int i=0;i<board.length;i++){
            for(int j=0;j<board[0].length;j++){
                if(board[i][j]==' '){
                    board[i][j]=currentSymbol;
                    int score=minmaxScore(currentSymbol==computerSymbol?playerSymbol:computerSymbol);
                    board[i][j]=' ';
                    if(currentSymbol==computerSymbol){
                        if(score>bestScore){

                            bestScore=score;
                        }

                    }
                    else{
                        if(score<bestScore){

                            bestScore=score;
                        }
                    }
                }
            }
        }
        return bestScore;

    }

    private static void player() {
        System.out.println("player 1");
        System.out.println("enter row:");
        int row=sc.nextInt()-1;
        System.out.println("enter col:");
        int col=sc.nextInt()-1;

        if(board[row][col]==' '){
            board[row][col]=playerSymbol;
        }
        else{
            System.out.println("enter a valid position");
            player();
        }

    }
    
    
}
