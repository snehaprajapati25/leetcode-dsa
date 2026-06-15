class Solution {
    public int maxProfit(int[] prices, int fee) {
        int n = prices.length;
        // int dp[][] = new int[n+1][2];
        int aheadBuy = 0 ; int aheadNotBuy = 0;
        int curBuy , curNotBuy;

        // dp[n][0] = dp[n][1] = 0;

        for(int i=n-1; i>=0; i--){
                //buy
                    curBuy = Math.max(-prices[i] - fee + aheadNotBuy , 0 + aheadBuy);

                //sell
                    curNotBuy = Math.max(prices[i] + aheadBuy , 0 + aheadNotBuy);

            aheadBuy = curBuy;
            aheadNotBuy = curNotBuy;
        }

        return aheadBuy;
    }
}