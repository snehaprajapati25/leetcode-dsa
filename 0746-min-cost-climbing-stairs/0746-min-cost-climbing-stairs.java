class Solution {
    public int f(int idx, int[] cost, int dp[]){
        if(idx == 0)return cost[0];
        if(idx == 1)return cost[1];

        if(dp[idx] != -1)return dp[idx];

        int firstStep = f(idx -1, cost, dp)+ cost[idx];
        int secondStep = f(idx -2, cost, dp)+ cost[idx];

        return dp[idx] = Math.min(firstStep, secondStep);
    }

    public int minCostClimbingStairs(int[] cost) {
        int dp[] = new int[cost.length];

        dp[0] = cost[0];
        dp[1] = cost[1];

        for(int i=2; i<cost.length; i++){
            dp[i] = cost[i] + Math.min(dp[i -1], dp[i -2]);
        }

        return Math.min(dp[cost.length-1], dp[cost.length-2]); // asked to reach TOP OF FLOOR i.e 10, 15, 20, TOP
    }
}