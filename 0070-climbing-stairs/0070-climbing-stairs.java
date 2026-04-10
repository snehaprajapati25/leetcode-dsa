class Solution {
    public int climbStairs(int n) {
        int dp[] = new int[n+1];
        dp[0] = 1; //for 0 stairs 1 way to reach it
        dp[1] = 1; //for 1 stairs 1 way to reach from 0 to 1

        for(int i=2; i<=n; i++){
            dp[i] = dp[i-1]+dp[i-2];
        }

        return dp[n];
    }
}