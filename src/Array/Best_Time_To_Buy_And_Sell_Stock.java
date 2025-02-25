package Array;

class Best_Time_To_Buy_And_Sell_Stock {
    public int maxProfit(int[] prices) {
        int min = 100000;
        int maxProfit = 0;
        for (int price : prices) {
            min = Math.min(min, price);
            maxProfit = Math.max(maxProfit, price - min);
        }
        return maxProfit;
    }
}