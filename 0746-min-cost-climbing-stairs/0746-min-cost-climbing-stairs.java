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
        
        Arrays.fill(dp, -1);
        

        return Math.min(f(cost.length-1, cost, dp), f(cost.length-2, cost, dp));
    }
}