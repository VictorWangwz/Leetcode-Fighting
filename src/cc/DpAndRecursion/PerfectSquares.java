package cc.DpAndRecursion;

//279. Perfect Squares
public class PerfectSquares {

    public int numSquares(int n) {
        int sqr = (int)Math.sqrt(n);
        int[] dict = new int[sqr];


        int[] dp = new int[n];
        dp[0] = 1;
        for(int i = 1; i <= sqr; i++){
            dp[i * i - 1] = 1;
        }
        for(int i = 1; i <= n;i++){
            int idx = i - 1;
            if(dp[idx] == 1){
                continue;
            }
            int min = Integer.MAX_VALUE;
            for(int j = 1; j <= (int)Math.sqrt(i); j++){
                if(dp[i - j*j - 1] < min){
                    min = dp[i - j*j - 1] ;
                }
            }
            dp[idx] = min + 1;

        }
        return dp[n - 1];
    }

    public static void main(String[] args) {
        int n = 12;
        PerfectSquares perfectSquares = new PerfectSquares();
        int rst = perfectSquares.numSquares(n);
        System.out.println(rst);
    }
}
