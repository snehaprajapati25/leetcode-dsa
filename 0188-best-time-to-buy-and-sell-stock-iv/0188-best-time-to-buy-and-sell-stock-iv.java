class Solution {
    public int maxProfit(int k, int[] prices) {
        int n = prices.length;
        int dp[][] = new int[n+1][2*k+1];

        //if n == 4 || transNo == 2k it will return 0 but no need to write this

        for(int ind=n-1; ind>=0; ind--){
            for(int transNo = 2*k-1; transNo>=0; transNo--){
                if(transNo % 2 == 0){
                    dp[ind][transNo] = Math.max(-prices[ind] + dp[ind+1][transNo+1], 0 + dp[ind+1][transNo]);
                }else{
                    dp[ind][transNo] = Math.max(prices[ind] + dp[ind+1][transNo+1], 0 + dp[ind+1][transNo]);
                }
            }
        }

        return dp[0][0];
    }
}