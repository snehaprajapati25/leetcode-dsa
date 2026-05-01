class Solution {
    public int uniquePaths(int m, int n) {
        int dp[][] = new int[m][n];

        for(int row[]: dp){
            Arrays.fill(row, -1); //since each row is an array
        }

        return funct(m-1, n-1, dp);
    }

    public int funct(int i, int j, int dp[][]){
        if(i==0 && j==0){
            return 1; //reached path return 1;
        }

        if(i<0 || j<0)return 0;

        if(dp[i][j] != -1)return dp[i][j];

        return dp[i][j] = funct(i-1,j, dp) + funct(i, j-1, dp);
    }
}