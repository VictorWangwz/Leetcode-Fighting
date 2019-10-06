package cc.DpAndRecursion;

//518. Coin Change 2
public class CoinChange2 {

    public static int change(int amount, int[] coins) {

        Integer[][] dp = new Integer[amount + 1][ coins.length + 1];
        for(int i = 0; i < amount + 1; i++){
            dp[i][0] = 0;
        }
        for(int j = 0; j < coins.length + 1; j++){
            dp[0][j] = 1;
        }
        return change(amount, coins, coins.length, dp);

    }

    private static int change(int amount, int[] coins, int coinLoc, Integer[][] dp){
        if(amount < 0){
            return 0;
        }
        if(dp[amount][coinLoc] == null){
            dp[amount][coinLoc] = change(amount, coins, coinLoc - 1, dp)
                    + change(amount - coins[coinLoc - 1], coins, coinLoc, dp);
        }

        return dp[amount][coinLoc];

    }

    public static void main(String[] args) {
       int amount = 5;
       int[] coins = {1,2,5};
       int rst = change(amount, coins);
       System.out.println(rst);
    }


}
