class Solution {
    public int coinChange(int[] coins, int amount) {
        int n = coins.length;
        int dp[][] = new int[n][amount+1];
        
        for(int row[]: dp){
            Arrays.fill(row, -1);
        }

        int ans = f(n-1, coins, amount, dp);
        return ans>= (int)1e9 ? -1: ans;
    }

    public int f(int i, int[] coins, int amount, int dp[][]){
        if(i==0){
            if(amount%coins[0] == 0){
                return amount/coins[0];
            }
            
            return (int)1e9;
        }

        if(dp[i][amount] != -1)return dp[i][amount];

        int notTake = 0 + f(i-1, coins, amount, dp);
        int take = Integer.MAX_VALUE;

        if(coins[i]<=amount) take = 1+f(i, coins, amount-coins[i], dp);

        return dp[i][amount] = Math.min(take,notTake);
    }
}