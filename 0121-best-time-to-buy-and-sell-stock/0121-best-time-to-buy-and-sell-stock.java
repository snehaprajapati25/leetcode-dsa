class Solution {
    public int maxProfit(int[] prices) {
        int buy = prices[0];
        int maxProfit = 0;
        
        for(int i=1; i<prices.length; i++){
            int cost = prices[i]-buy;
            maxProfit = Math.max(cost, maxProfit);
            buy = Math.min(buy, prices[i]);
        }

        return maxProfit;
    }
}