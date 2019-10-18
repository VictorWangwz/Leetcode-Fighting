package cc.TreesAndGraphs;

//221. Maximal Square
public class MaximalSquare {

    private int cal(char[][] matrix, int r, int c, int len){
        if(r + len > matrix.length){
            return -1;
        }
        for(int i = r; i < r + len; i++){
            for(int j = c; j > c- len; j--){
                if(matrix[i][j] == '0'){
                    return -1;
                }
            }
        }
        return len;
    }
    public int maximalSquare(char[][] matrix) {
        if(matrix == null || matrix.length == 0 || matrix[0].length == 0){
            return 0;
        }
        int len = 0;
        for(int i = 0; i < matrix.length; i++){
            int tmpLen = 0;
            for(int j = 0; j < matrix[0].length; j++){

                if(matrix[i][j] == '1'){
                    tmpLen ++;
                }
                else{
                    tmpLen = 0;
                }
                if(tmpLen > len){
                    for(int l = len + 1; l <= tmpLen; l++){
                        int tmp = cal(matrix, i, j, l);
                        if(tmp != -1){
                            len = tmp;
                        }
                    }

                }
            }
        }
        return len * len;

    }

    public int maximalSquare1(char[][] matrix) {
        int m = matrix.length, n = matrix[0].length;
        int[][] dp = new int[m + 1][n + 1];
        int rst = 0;
        for(int i = 1; i < m + 1; i++){
            for(int j = 1; j < n + 1; j++){
                if(matrix[i - 1][j - 1] == '1'){
                    dp[i][j] =Math.min(Math.min(dp[i - 1][j], dp[i][j - 1]), dp[i - 1][j - 1]) + 1;
                    if(dp[i][j] > rst){
                        rst = dp[i][j];
                    }
                }
            }
        }
        return rst * rst;
    }

    public static void main(String[] args) {
        char[][] matrix
                = {
                {'0','0','0','1'},
                {'1','1','0','1'},
                {'1','1','1','1'},
                {'0','1','1','1'},
                {'0','1','1','1'}
        };
        MaximalSquare maximalSquare = new MaximalSquare();
        int rst =maximalSquare.maximalSquare1(matrix);
        System.out.println(rst);
    }
}
