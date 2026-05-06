class Solution {
    public int f(int i, int j1, int j2, int r, int c, int[][] grid, int dp[][][]){
        //out of boundary case
        if(j1<0 || j2<0 || j1>=c || j2>=c)return -(int)1e8;

        //at destination
        if(i == r-1){
            if(j1 == j2)return grid[i][j1];
            else return grid[i][j1]+grid[i][j2];
        }

        if(dp[i][j1][j2] != -1)return dp[i][j1][j2];

        //explore all the stuffs
        int maxi = -(int)1e8;
        for(int d1=-1; d1<=1; d1++){
            for(int d2=-1; d2<=1; d2++){
                int value = 0;
                if(j1 == j2) value += grid[i][j1]; //if col are same add once
                else value += grid[i][j1] + grid[i][j2];
                value += f(i+1, j1+d1, j2+d2, r, c, grid, dp);

                maxi = Math.max(value, maxi);
            }
        }
        return dp[i][j1][j2] = maxi;
    }

    public int cherryPickup(int[][] grid) {
        int r = grid.length;
        int c = grid[0].length;
        int dp[][][] = new int[r][c][c];

        for(int row[][]: dp){
            for(int col[]: row){
                Arrays.fill(col, -1);
            }
        }
        return f(0, 0, c-1, r, c, grid, dp);
    }
}