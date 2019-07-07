package vopreparation0530;


import java.util.Arrays;

//322. Coin Change
public class CoinChange {

    public static int coinChange(int[] coins, int amount) {
        if(amount == 0) return 0;
        if(amount < 0) return -1;
        int[] dp = new int[amount + 1];
        Arrays.sort(coins);
        Arrays.fill(dp, amount + 1);
        dp[0] = 0;
        for(int i = 1; i < amount + 1; i++){
            for(int j = 0; j < coins.length; j++){
                if(i >= coins[j])
                    dp[i] = Math.min(dp[i], dp[i - coins[j]] + 1);
            }
        }
        return dp[amount] < amount + 1 ? dp[amount]: -1;
    }

    public static void main(String[] args) {
        int[] coins = {2};
        int amount = 3;
        int expected = 3;
        int rst = coinChange(coins, amount);
        System.out.println(rst == expected);
    }
}
