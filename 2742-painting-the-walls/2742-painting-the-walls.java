class Solution {
    // public int f(int[] cost, int[] time, int idx, int walls, int dp[][]){
    //     if(walls <= 0)return 0; //all walls are painted
    //     if(idx < 0) return (int)1e9; //no walls left

    //     if(dp[idx][walls] != -1)return dp[idx][walls];

    //     int free = 0 + f(cost, time, idx-1, walls, dp);
    //     int paid  = cost[idx] + f(cost, time, idx-1, walls-time[idx]-1, dp); //paid painter has already painted one wall

    //     return dp[idx][walls] = Math.min(free, paid);
    // }
    
    public int paintWalls(int[] cost, int[] time) {
        int n = cost.length;
        int dp[][] = new int[n][n+1];

        for (int row[] : dp) {
            Arrays.fill(row, (int)1e9);
        } 

        for(int i=0; i<n; i++)dp[i][0] = 0; //walls are 0(means all walls painted)

        //for idx = 0 only 1 painter wil be available //Minimum cost to paint walls walls using ONLY painter 0.
        for(int walls=1; walls<=n; walls++){ 
            if(walls<= 1+time[0])dp[0][walls] = cost[0];     //“Can painter 0 alone complete the required number of walls?” 1 painted by paid while time[0] by free painter   
        }

        for(int idx=1; idx<n; idx++){
            for(int walls=1; walls<=n; walls++){
                int free = 0 + dp[idx-1][walls];
                int remaining   = Math.max(0, walls-time[idx]-1);
                int paid = cost[idx] + dp[idx-1][remaining]; //paid painter has already painted one wall

                dp[idx][walls] = Math.min(free, paid);
            }
        }
        return dp[n-1][n];
    }
}