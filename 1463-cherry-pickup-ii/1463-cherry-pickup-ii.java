class Solution {
    // public int f(int i, int j1, int j2, int r, int c, int[][] grid, int dp[][][]) {
    //     //out of boundary case
    //     if (j1 < 0 || j2 < 0 || j1 >= c || j2 >= c)
    //         return -(int) 1e8;

    //     //at destination
    //     if (i == r - 1) {
    //         if (j1 == j2)
    //             return grid[i][j1];
    //         else
    //             return grid[i][j1] + grid[i][j2];
    //     }

    //     if (dp[i][j1][j2] != -1)
    //         return dp[i][j1][j2];

    //     //explore all the stuffs
    //     int maxi = -(int) 1e8;
    //     for (int d1 = -1; d1 <= 1; d1++) {
    //         for (int d2 = -1; d2 <= 1; d2++) {
    //             int value = 0;
    //             if (j1 == j2)
    //                 value += grid[i][j1]; //if col are same add once
    //             else
    //                 value += grid[i][j1] + grid[i][j2];
    //             value += f(i + 1, j1 + d1, j2 + d2, r, c, grid, dp);

    //             maxi = Math.max(value, maxi);
    //         }
    //     }
    //     return dp[i][j1][j2] = maxi;
    // }

    public int cherryPickup(int[][] grid) {
        int n = grid.length;//row
        int m = grid[0].length;//col
        int dp[][][] = new int[n][m][m];

        //if at last row
        for(int j1=0; j1<m; j1++){
            for(int j2=0; j2<m; j2++){
                if(j1 == j2)dp[n-1][j1][j2] = grid[n-1][j1];
                else{
                    dp[n-1][j1][j2] = grid[n-1][j1]+ grid[n-1][j2];
                }
             }
        }

        for(int i=n-2; i>=0; i--){
            for(int j1=0; j1<m; j1++){
                for(int j2=0; j2<m; j2++){

                    int maxi = -(int)1e8;
                    //paths can go from col = j-1 to j+1
                    for(int d1=-1; d1<=1; d1++){
                        for(int d2=-1; d2<=1; d2++){
                            int value = 0;
                            if(j1 == j2) value += grid[i][j1]; //if col are same add once
                            else value += grid[i][j1] + grid[i][j2];
                            
                            if(j1+d1 >= 0 && j1+d1<m && j2+d2>=0 && j2+d2<m){
                                value += dp[i+1][j1+d1][j2+d2];
                            }else value += -1e8;

                            maxi = Math.max(value, maxi);
                        }
                    }
                    dp[i][j1][j2] = maxi;
                }
            }
        }
        return dp[0][0][m-1];
    }
}