package googleoa;
//410. Split Array Largest Sum
class SplitArrayLargestSum {
    public int splitArray(int[] nums, int m) {
        int n = nums.length;
        int[][] help = new int[n + 1][m +1];
        int[] sub = new int[n + 1];
        for(int i = 0; i < n + 1; i++){
            for(int j = 0; j <= m; j++){
                help[i][j] = Integer.MAX_VALUE;
            }
        }
        for(int i = 0; i < n; i++){
            sub[i + 1] = sub[i] + nums[i];
        }

        help[0][0] = 0;

        for(int i = 1; i < n + 1; i++){
            for(int j  = 1; j <= m; j++){
                for(int k = 0; k < i; k++){
                    help[i][j] = Math.min(help[i][j], Math.max(help[k][j - 1], sub[i] - sub[k]));
                }
            }
        }
        return help[n][m];
    }
}