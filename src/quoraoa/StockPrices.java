package quoraoa;

import java.util.stream.IntStream;

public class StockPrices {

    public int maxPriceReturn(int[] prices, int[] algo, int k){
        int[] rises = new int[prices.length - k + 1];
        for(int i = 0; i <= prices.length - k ; i++){
            if(i == 0){
                int rise = 0;
                for(int j = 0; j < k; j++){
                    if(algo[i + j] == 0){
                        rise += 2 * prices[i + j];
                    }
                }
                rises[i] = rise;
            }
            else{
                rises[i] = rises[i - 1] + algo[i - 1] == 0? -2 * prices[i - 1]:0 + algo[i + k - 1] == 0? 2* prices[i + k -1]: 0;
            }
        }

        int oriReturn = 0;
        for(int i = 0; i < prices.length; i++){
            oriReturn += algo[i] == 0? -1 *prices[i]: prices[i];
        }

        int maxRise = IntStream.of(rises).max().getAsInt();
        return oriReturn + maxRise;
    }

    public static void main(String[] args) {
        int[] prices = {1,2,3,4},
                algo = {0,1,0,1};
        int k = 2;
        StockPrices stockPrices = new StockPrices();
        int rst = stockPrices.maxPriceReturn(prices, algo, k);
        System.out.println(rst);
    }
}
