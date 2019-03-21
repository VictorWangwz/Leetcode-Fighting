import java.util.Arrays;

public class CoinChange {

    public int coinChange(int[] coins, int amount) {
        if(amount == 0){
            return 0;
        }
        if(amount < 0){
            return -1;
        }
        int[] nums = new int[amount + 1];
        Arrays.fill(nums, amount + 1);
        nums[0] = 0;
        for(int i = 1; i< amount + 1; i++){
            for(int j = 0; j< coins.length; j++){
                if(i >= coins[j]){
                    nums[i] = Math.min(nums[i], nums[i - coins[j]] + 1);
                }
            }
        }
        return nums[amount] <= amount? nums[amount]: -1;
    }

    public static void main(String[] args) {
        CoinChange c = new CoinChange();
        int[] coins = {2};
        int amount = 3;
        System.out.println(c.coinChange(coins, amount));
    }
}
