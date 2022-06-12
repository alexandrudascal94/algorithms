public class ArrayTraversing_BestTimeBuySellStock2 {
    //[7, 1, 5, 3, 6, 4]
    // buy at i. and check with i + 1, if i + 1 is maller then sell
    // https://leetcode.com/problems/best-time-to-buy-and-sell-stock-ii/
    public int maxProfit(int[] prices) {
        if(prices.length == 0){
            return 0;
        }

        int profit = 0;

        for(int i = 0; i < prices.length -1; ++i){
            //if today price is smaller the tomorrow
            //I buy today and sell tomorrow
            if(prices[i] < prices[i + 1]){
                profit += prices[i + 1] - prices[i];
            }
        }
        return profit;
    }
}
