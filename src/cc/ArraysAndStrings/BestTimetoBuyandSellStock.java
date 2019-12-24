package cc.ArraysAndStrings;
//121. Best Time to Buy and Sell Stock
public class BestTimetoBuyandSellStock {
    public int maxProfit(int[] prices) {
        if(prices == null || prices.length == 0){
            return 0;
        }
        int[] max = new int[prices.length];
        int maxSF = Integer.MIN_VALUE;
        for(int i = prices.length - 1; i >= 0; i--){
            if(prices[i] > maxSF){
                maxSF = prices[i];
            }
            max[i] = maxSF;
        }
        int rst = Integer.MIN_VALUE;
        for(int i = 0; i < prices.length; i++){
            if(max[i] - prices[i] > rst){
                rst = max[i] - prices[i] ;
            }
        }
        return rst;
    }
}
