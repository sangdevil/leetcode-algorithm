package Array;

class Best_Time_To_Buy_And_Sell_Stock_2 {
    public int maxProfit(int[] prices) {
        int previousPrice = prices[0];
        int maxProfit = 0;
        for(int i = 1; i < prices.length; i++) {
            if (previousPrice < prices[i]) {
                maxProfit += prices[i] - previousPrice;
            }
            previousPrice = prices[i];
        }

        return maxProfit;
    }
}