class Solution {
    public int maxProfit(int[] prices) {
        int maxProfit = 0;
        int curPrice = prices[0];

        for(int i=1; i<prices.length; i++){
            int profit = prices[i] - curPrice;

            maxProfit = Math.max(maxProfit, profit);
            curPrice = Math.min(prices[i], curPrice);
        }

        return maxProfit;
    }
}