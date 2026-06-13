class Solution {
    public int maxProfit(int[] prices) {
        int n = prices.length;
        int dp[][] = new int[n+1][5]; //4 -> transaction B, S, B, S

        for(int ind=n-1; ind>=0; ind--){
                for(int transNo=3; transNo>=0; transNo--){
                    if(transNo % 2 == 0){ //buy
                        dp[ind][transNo] = Math.max(-prices[ind] + dp[ind+1][transNo+1], 0 + dp[ind+1][transNo]);
                    }else{
                        dp[ind][transNo] = Math.max(prices[ind] + dp[ind+1][transNo+1], 0 + dp[ind+1][transNo]);
                    }
                }
        }

        return dp[0][0];
    }
}