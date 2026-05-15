class Solution {
    public int f(int[] cost, int[] time, int idx, int walls, int dp[][]){
        if(walls <= 0)return 0; //all walls are painted
        if(idx < 0) return (int)1e9; //no walls left

        if(dp[idx][walls] != -1)return dp[idx][walls];

        int free = 0 + f(cost, time, idx-1, walls, dp);
        int paid  = cost[idx] + f(cost, time, idx-1, walls-time[idx]-1, dp); //paid painter has already painted one wall

        return dp[idx][walls] = Math.min(free, paid);
    }
    
    public int paintWalls(int[] cost, int[] time) {
        int n = cost.length;
        int dp[][] = new int[n][n+1]; 

        for(int row[]: dp){
            Arrays.fill(row, -1);
        }
        return f(cost, time, n-1, n, dp);
    }
}