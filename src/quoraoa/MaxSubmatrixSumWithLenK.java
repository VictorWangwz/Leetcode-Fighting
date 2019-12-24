package quoraoa;

import java.util.HashSet;
import java.util.Set;

public class MaxSubmatrixSumWithLenK {
    public int getMaxSum(int[][] matrix, int k){
        if(matrix == null || matrix.length == 0 || matrix[0].length == 0
                || matrix.length < k || matrix[0].length < k){
            return -1;
        }
        int m = matrix.length, n = matrix[0].length;
        int[][] dp = new int[m - k + 1][n - k + 1];
        Set<Integer> set = new HashSet<>();
        int max = Integer.MIN_VALUE;
        for(int i = 0; i < m - k + 1; i++){
            for(int j = 0; j < n - k + 1; j++) {
                if (i == 0 && j == 0) {
                    int sum = 0;
                    for (int a = i; a < i + k; a++) {
                        for (int b = j; b < j + k; b++) {
                            sum += matrix[a][b];
                        }
                    }
                    dp[i][j] = sum;
                } else if (i == 0) {
                    int sum = dp[i][j - 1];
                    for (int a = i; a < i + k; a++) {
                        sum += matrix[a][j - 1];
                        sum -= matrix[a][j + k - 1];
                    }
                    dp[i][j] = sum;
                } else {
                    int sum = dp[i - 1][j];
                    for (int a = j; a < j + k; a++) {
                        sum += matrix[i - 1][a];
                        sum -= matrix[i + k - 1][a];
                    }
                    dp[i][j] = sum;
                }
                if (dp[i][j] > max) {
                    max = dp[i][j];
                }
            }
        }
        for(int i = 0; i < m - k + 1; i++){
            for(int j = 0; j < n - k + 1; j++) {
                if(dp[i][j] == max){
                    for (int a = i; a < i + k; a++) {
                        for (int b = j; b < j + k; b++) {
                            set.add(matrix[a][b]);
                        }
                    }
                }
            }
        }
        return set.stream().mapToInt(i -> i).sum();

    }

    public static void main(String[] args) {
        int[][] matrix = {
                {1,2,3},
                {4,2,2}
        };
        int k = 2;
        MaxSubmatrixSumWithLenK maxSubmatrixSumWithLenK = new MaxSubmatrixSumWithLenK();
        int rst = maxSubmatrixSumWithLenK.getMaxSum(matrix, k);
        System.out.println(rst);
    }
}
