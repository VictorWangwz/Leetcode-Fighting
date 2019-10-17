package greedy;
//Best Time to Buy and Sell Stock II
public class BestTimetoBuyandSellStockII {
    public int maxProfit(int[] prices) {
        int rst = 0;
        if(prices.length < 2){
            return rst;
        }
        for(int i = 1; i< prices.length; i++){
            if(prices[i] > prices[i -1 ]){
                rst += prices[i] - prices[i - 1];
            }
        }
        return rst;
    }
}
