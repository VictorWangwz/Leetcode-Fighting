//79
public class WordSearch {
    public static boolean checkPath(char[][] board, int i, int j, String word, int k){
        if(i < 0 || i >= board.length || j < 0 || j >= board[0].length)
            return false;

        if(board[i][j] == word.charAt(k)){
            k++;
            if(k == word.length() ) return true;
            char temp = board[i][j];
            board[i][j] = '@';
            if(checkPath(board, i + 1, j, word, k)) return true;
            if(checkPath(board, i - 1, j, word, k)) return true;
            if(checkPath(board, i, j - 1, word, k)) return true;
            if(checkPath(board, i, j + 1, word, k)) return true;
            board[i][j] = temp;
        }
        return false;
    }
    public static boolean exist(char[][] board, String word) {
        boolean rst = false;
        for(int i = 0; i < board.length; i++){
            for(int j = 0; j < board[0].length; j++){
                if(board[i][j] == word.charAt(0)){
                    rst = checkPath(board, i, j, word, 0);
                    if (rst)
                        return true;
                }
            }
        }
        return false;
    }

    public static void main(String[] args) {
        char[][] board = {
                {'A','B','C','E'},
                {'S','F','C','S'},
                {'A','D','E','E'}
        };
        String word = "ABCCED";
        boolean rst = exist(board, word);
        System.out.println(rst);
    }
}
