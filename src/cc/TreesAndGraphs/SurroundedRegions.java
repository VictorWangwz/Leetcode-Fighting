package cc.TreesAndGraphs;
//130. Surrounded Regions
public class SurroundedRegions {


    private static boolean dfs(char[][] board, int i, int j){
        if( i >= board.length -  1 || j >= board[0].length - 1 || i <= 0 || j <= 0){
            if(board[i][j] == 'O'){
                return false;
            }
            else return true;
        }
        boolean left = dfs(board, i - 1, j);
        boolean right = dfs(board, i + 1, j);
        boolean top = dfs(board, i, j - 1);
        boolean bot = dfs(board, i, j + 1);
        return left && right && top && bot;
    }

    public static void solve(char[][] board) {

        for( int i = 0; i < board.length; i++){
            for( int j = 0; j < board[0].length; j++){
                if(board[i][j] == 'O'){
                    if(dfs(board, i, j)){
                        board[i][j] = 'X';
                    }
                }
            }
        }
    }

    public static void main(String[] args) {
        char[][] board = {
                {'X','X','X','X'},
                {'X','O','O','X'},
                {'X','X','O','X'},
                {'X','O','X','X'}
        };
        solve(board);

    }
}
