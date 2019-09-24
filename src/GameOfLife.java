//289
public class GameOfLife {

    public static int computeLife(int[][] board, int i, int j){
        int xLeft = Math.max(i - 1, 0), xRight = Math.min(board.length - 1, i + 1),
                yUp = Math.min(j + 1, board[0].length - 1), yDown = Math.max(j - 1, 0);
        int liveNum = 0;
        for( int m = xLeft; m <= xRight; m ++){
            for(int n = yDown; n <= yUp; n++){
                if(m == i && n == j) continue;
                if(board[m][n] == 1) liveNum ++;
            }
        }
        if(board[i][j] == 0 && liveNum == 3) return 1;
        if(board[i][j] == 1){
            if(liveNum < 2 || liveNum > 3) return 0;
            else return 1;
        }
        return 0;
    }
    public static void gameOfLife(int[][] board) {
        if(board == null || board.length == 0 || board[0].length == 0) return ;
        int[][] rst = new int[board.length][board[0].length];
        for(int i = 0; i < board.length; i++){
            for(int j = 0; j < board[0].length; j++){
                rst[i][j] = computeLife(board, i, j);
            }
        }
        for(int i = 0; i < board.length; i++){
            for(int j = 0; j < board[0].length; j++){
                board[i][j] = rst[i][j];
            }
        }
    }

    public static void main(String[] args) {
        int[][] board = {
                {0,1,0},
                {0,0,1},
                {1,1,1},
                {0,0,0}
        };
        gameOfLife(board);
        System.out.println(board);
    }
}
