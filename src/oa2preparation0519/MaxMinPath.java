package oa2preparation0519;

public class MaxMinPath {

    // DP
    public static int minMaxPath(int[][] matrix) {
        if(matrix.length == 0 || matrix[0].length == 0)
            return 0;
        int m = matrix.length, n = matrix[0].length;
        int[][] dp = new int[m][n];
        dp[0][0] = matrix[0][0];
        for(int i = 1; i < matrix.length; i++) dp[i][0] = Math.min(dp[i - 1][0], matrix[i][0]);
        for(int i = 1; i < matrix[0].length; i++) dp[0][i] = Math.min(dp[0][i - 1], matrix[0][i - 1]);

        for(int i = 1; i < matrix.length; i++){
            for(int j = 1; j < matrix[0].length; j++){
                if(matrix[i][j] > Math.max(dp[i - 1][j], dp[i][j - 1])){
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
                }
                else{
                    dp[i][j] = matrix[i][j];
                }

            }
        }
        return dp[m - 1][n - 1];
    }

    // DFS
    static int min_max = Integer.MIN_VALUE;
    public static int minMaxPath2(int[][] matrix) {
        dfsHelper(matrix, 0, 0, Integer.MAX_VALUE);
        return min_max;
    }

    public static void dfsHelper(int[][] matrix, int i, int j, int min){
        if(i >= matrix.length || j >= matrix[0].length) return;
        min = Math.min(matrix[i][j], min);
        if(i == matrix.length - 1 && j == matrix[0].length - 1){
            min_max = Math.max(min, min_max);
            return;
        }
        dfsHelper(matrix, i + 1, j, min);
        dfsHelper(matrix, i, j + 1, min);

    }


    public static void main(String[] args) {
//        int[][] matrix = {
//                {8, 4, 7},
//                {6, 5, 9}
//        };
        int[][] matrix = {{5,4, 5}, {1, 3, 6}};
        int rst = minMaxPath2(matrix);
        System.out.println(rst);
    }
}
