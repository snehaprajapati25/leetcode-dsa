class Solution {
    public int coinChange(int[] coins, int amount) {
        int n = coins.length;
        int dp[][] = new int[n][amount+1];
        
        for(int j=0; j<=amount; j++){
            if(j % coins[0] == 0){
                dp[0][j] = j/coins[0];
            }else dp[0][j] = (int)1e9;
        }

        for(int i=1; i<n; i++){
            for(int j=0; j<=amount; j++){
                int notTake = 0 + dp[i-1][j];
                int take = (int)1e9;

                if(coins[i]<=j) take = 1+ dp[i][j-coins[i]];

                dp[i][j] =  Math.min(take,notTake);
            }
        }

        int ans = dp[n-1][amount];

        return ans >= (int)1e9? -1: ans;
    }

    // public int f(int i, int[] coins, int amount, int dp[][]){
    //     if(i==0){
    //         if(amount%coins[0] == 0){
    //             return amount/coins[0];
    //         }
            
    //         return (int)1e9;
    //     }

    //     if(dp[i][amount] != -1)return dp[i][amount];

    //     int notTake = 0 + f(i-1, coins, amount, dp);
    //     int take = Integer.MAX_VALUE;

    //     if(coins[i]<=amount) take = 1+f(i, coins, amount-coins[i], dp);

    //     return dp[i][amount] = Math.min(take,notTake);
    // }
}