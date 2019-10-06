package cc.TreesAndGraphs;
//130. Surrounded Regions
public class SurroundedRegions {


    private static void color(char[][] board, int i, int j){
        if(i < 0 || i >= board.length || j < 0 || j >= board[0].length){
            return;
        }
        if(board[i][j] == 'O'){
            board[i][j] = '*';
            color(board, i - 1, j);
            color(board, i + 1, j);
            color(board, i, j - 1);
            color(board, i, j + 1);
        }
        else{
            return;
        }


    }

    public static void solve(char[][] board) {
        if( board == null || board.length == 0 || board[0].length == 0){
            return;
        }

        int m = board.length, n = board[0].length;
        for(int i = 0; i < m ; i++ ){
            color(board, i, 0);
            color(board, i, n - 1);

        }
        for(int i = 0; i < n; i++){
            color(board, 0, i);
            color(board, m - 1, i);

        }
        for( int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
                if(board[i][j] == 'O'){
                    board[i][j] = 'X';
                }
                if(board[i][j] == '*'){
                    board[i][j] = 'O';
                }
            }
        }
        return;

    }

    public static void main(String[] args) {
        char[][] board = {
                {'X','O','X','O','X','O'},
                {'O','X','O','X','O','X'},
                {'X','O','X','O','X','O'},
                {'O','X','O','X','O','X'}
        };
        solve(board);

    }
}
