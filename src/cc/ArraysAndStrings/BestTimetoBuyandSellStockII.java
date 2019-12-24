package cc.ArraysAndStrings;
//122. Best Time to Buy and Sell Stock II
public class BestTimetoBuyandSellStockII {

    public int maxProfit(int[] prices) {
        if(prices == null || prices.length == 0){
            return 0;
        }
        int[] dp = new int[prices.length];
        dp[prices.length - 1] = 0;
        int rst = 0;
        for(int i = prices.length - 2; i >= 0; i--){
            int max = dp[i + 1];
            for(int j = i; j < prices.length; j++){
                if(max < prices[j] - prices[i] + dp[j]){
                    max = prices[j] - prices[i] + dp[j];
                }
            }
            if(rst < max){
                rst = max;
            }
            dp[i] = max;
        }
        return rst;
    }
}
