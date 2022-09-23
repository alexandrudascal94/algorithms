public class ArrayTraversing_BestTimeBuySellStock {
    public int maxProfit(int[] prices) {
        // [7, 1, 5, 3, 6, 4]
        // buy = 7, 1, 1, 1, 1
        // sell = 1, 5, 3, 6, 4
        // -6, 4, 2, 5, 3
        // we move left when is negative.

        int buyIdx = 0;
        int sellIdx = 1;
        int maxProfit = 0;

        while (sellIdx < prices.length) {
            int buy = prices[buyIdx];
            int sell = prices[sellIdx];

            if (buy > sell) {
                buyIdx = sellIdx;
                sellIdx++;
            } else {
                maxProfit = Math.max(sell - buy, maxProfit);
                sellIdx++;
            }
        }
        return maxProfit;
    }
}

