package gfg.problem.backtracking;

import javafx.util.Pair;

import java.util.Stack;


public class QueensProblem {
    public static void main(String[] args) {
        backtrackingMethod();
    }

    private static void backtrackingMethod() {
        boolean[][] board = new boolean[4][4];
        Stack<Pair<Integer,Integer>> stk = new Stack<>();
        int jRewind = 0;
        for (int i=0;i<4;i++){
            boolean queenSet = false;
            for (int j=jRewind;j<4;j++){
                if (isSafe(board,i,j)){
                    board[i][j]=true;
                    queenSet = true;
                    stk.push(new Pair<>(i,j));
                    break;
                }
            }
            if (!queenSet){
                Pair<Integer,Integer> pair = stk.pop();
                board[pair.getKey()][pair.getValue()] = false;
                i=pair.getKey()-1;
                jRewind = pair.getValue()+1;
            }else {
                jRewind = 0;
            }
        }
        printMatrix(board);
    }

    private static void printMatrix(boolean[][] board) {
        for (int i=0;i<4;i++){
            for (int j=0;j<4;j++){
                System.out.print(board[i][j]?" Q ":" _ ");
            }
            System.out.println();
        }
    }

    private static boolean isSafe(boolean[][] board, int row, int col) {
        for (int i=row;i>=0;i--){
            if (board[i][col])
                return false;
        }
        for (int i=row,j=col;i>=0 && j>=0;i--,j--){
            if (board[i][j])
                return false;
        }
        for (int i=row,j=col;i>=0 && j<4;i--,j++){
            if (board[i][j])
                return false;
        }
        return true;
    }
}
