package cc.TreesAndGraphs;

import java.util.HashSet;
import java.util.Set;

//36. Valid Sudoku

//todo to debug

public class ValidSudoku {

    private boolean check(char[][] board, int r, int c){
        Set<Character> set = new HashSet<>();
        for(int i = 3 * r; i < 3*(r + 1); i++){
            for(int j = 3 * c; j < 3 *(c + 1); j++){
                if(board[i][j] >= '1' && board[i][j] <='9' ){
                    if(set.contains(board[i][j])){
                        return false;
                    }
                    set.add(board[i][j]);
                }
            }
        }
        return true;
    }


    public boolean isValidSudoku(char[][] board) {
        Set<Character> set = new HashSet<>();
        for(int i = 0; i < board.length; i++){
            for(int j = 0; j < board[0].length; j++){
                if(board[i][j] >= '1' && board[i][j] <='9' ){
                    if(set.contains(board[i][j])){
                        return false;
                    }
                    set.add(board[i][j]);
                }
            }
            set.clear();
        }
        set.clear();

        for(int i = 0; i < board[0].length; i++){
            for(int j = 0; j < board.length; j++){
                if(board[i][j] >= '1' && board[i][j] <='9' ){
                    if(set.contains(board[i][j])){
                        return false;
                    }
                    set.add(board[i][j]);
                }
            }
            set.clear();
        }

        set.clear();

        for(int i = 0 ; i < 3; i++){
            for(int j = 0; j < 3; j++){
                if(!check(board, i, j)){
                    return false;
                }
            }
        }
        return true;
    }

    public static void main(String[] args) {
        String[][] boardS =
                {
                        {"8","3",".",".","7",".",".",".","."},
                        {"6",".",".","1","9","5",".",".","."},
                        {".","9","8",".",".",".",".","6","."},
                        {"8",".",".",".","6",".",".",".","3"},
                        {"4",".",".","8",".","3",".",".","1"},
                        {"7",".",".",".","2",".",".",".","6"},
                        {".","6",".",".",".",".","2","8","."},
                        {".",".",".","4","1","9",".",".","5"},
                        {".",".",".",".","8",".",".","7","9"}

                };
        char[][] board = new char[9][9];
        for(int i = 0; i < 9; i++){
            for(int j = 0; j < 9; j++){
                board[i][j] = boardS[i][j].charAt(0);
            }
        }
        ValidSudoku validSudoku = new ValidSudoku();
        boolean rst = validSudoku.isValidSudoku(board);
        System.out.println(rst);


    }
}
