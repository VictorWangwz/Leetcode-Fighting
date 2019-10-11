//348. Design Tic-Tac-Toe

public class TicTacToe {
    private int n;
    private int[][] board ;
    private int[] rowStatus;
    private int[] colStatus;
    private int[] crossStatus;

    /** Initialize your data structure here. */
    public TicTacToe(int n) {
        this.n = n;
        board = new int[n][n];
        rowStatus = new int[n];
        colStatus = new int[n];
        crossStatus = new int[2];

    }

    /** Player {player} makes a move at ({row}, {col}).
     @param row The row of the board.
     @param col The column of the board.
     @param player The player, can be either 1 or 2.
     @return The current winning condition, can be either:
     0: No one wins.
     1: Player 1 wins.
     2: Player 2 wins. */
    public int move(int row, int col, int player) {
        board[row][col] = player;
        int n = board.length;
        rowStatus[row] ++;
        if(rowStatus[row] == n){
            int i = 0;
            for( ;i < n; i++){
                if(board[row][i] != player){
                    break;
                }
            }
            if(i == n){
                return player;
            }
        }

        colStatus[col] ++;
        if(colStatus[col] == n){
            int i = 0;
            for( ;i < n; i++){
                if(board[i][col] != player){
                    break;
                }
            }
            if(i == n){
                return player;
            }
        }

        if(row == col){
            crossStatus[0]++;
            if(crossStatus[0] == n){
                int i = 0;
                for( ;i < n; i++){
                    if(board[i][i] != player){
                        break;
                    }
                }
                if(i == n){
                    return player;
                }
            }
        }

        if(row + col == n - 1){
            crossStatus[1]++;
            if(crossStatus[1] == n){
                int i = 0;
                for( ;i < n; i++){
                    if(board[i][n - 1 - i] != player){
                        break;
                    }
                }
                if(i == n){
                    return player;
                }
            }
        }
        return 0 ;


    }
}
