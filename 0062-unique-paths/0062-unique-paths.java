class Solution {
    // public int f(int i, int j, int dp[][]){
    //     if(i==0 && j==0)return 1;

    //     if(i<0 || j<0)return 0;

    //     if(dp[i][j] != -1)return dp[i][j];

    //     int up = f(i-1, j, dp);
    //     int left = f(i, j-1, dp);

    //     return dp[i][j] = up+left;
    // }

    public int uniquePaths(int m, int n) {
        int prev[] = new int[n];

        // dp[0][0] = 1;

        for(int i=0; i<m; i++){
            int cur[] = new int[n];
            for(int j=0; j<n; j++){
                if(i == 0 && j==0 ){
                    cur[j] = 1;
                    continue;
                }
                    int up=0, left=0;

                    if(i>0)up = prev[j];
                    if(j>0)left = cur[j-1];
                    cur[j] = up+left;
            }
            prev = cur;
        }

        return prev[n-1];
    }
}