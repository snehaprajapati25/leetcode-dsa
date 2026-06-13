class Solution {
    public int maxProfit(int[] prices) {
        int n = prices.length;
        int after[] = new int[2];

        // dp[n][0] = dp[n][1] = 0;

        for(int ind=n-1; ind>=0; ind--){
            int cur[] = new int[2];

            for(int buy=0; buy<=1; buy++){
                int profit = 0;

                if(buy == 1){ //buy
                    profit = Math.max(-prices[ind] + after[0], 0 + after[1]); 
                }else{ //sell
                    profit = Math.max(prices[ind] + after[1], 0 + after[0]);
                }

                cur[buy] = profit;
            }
            after = cur;
        }

        return after[1];
    }
}