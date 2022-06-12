public class ArrayTraversing_BestTimeBuySellStock {
    // [7,1,5,3,6,4]
    //
    //
    public int maxProfit(int[] prices) {
        if(prices.length == 0){
            return 0;
        }
        int profit = 0;
        int minPrice = prices[0];

        for(int i = 1; i < prices.length; ++i){
            int curProfit = prices[i] - minPrice;
            if(curProfit > profit){
                profit = curProfit;
            }

            minPrice = Math.min(minPrice, prices[i]);
        }

        return profit;
    }
}
