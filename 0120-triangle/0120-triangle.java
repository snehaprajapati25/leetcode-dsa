class Solution {
    public int f(List<List<Integer>> triangle, int i, int j, int dp[][]){
        //at last row 
        if(i == triangle.size()-1)return triangle.get(i).get(j);

        if(dp[i][j] != -1)return dp[i][j];

        int down = triangle.get(i).get(j) + f(triangle, i+1, j, dp);
        int dg = triangle.get(i).get(j) + f(triangle, i+1, j+1, dp);

        return dp[i][j] = Math.min(down, dg);
    }

    public int minimumTotal(List<List<Integer>> triangle) {
        int n = triangle.size();
        int dp[][] = new int[n][n];

        //base case when it is at last row
        for(int j=0; j<n; j++){
            dp[n-1][j] = triangle.get(n-1).get(j);
        }

        for(int i=n-2; i>=0; i--){
            for(int j=i; j>=0; j--){
                int down = triangle.get(i).get(j) + dp[i+1][j];
                int dg = triangle.get(i).get(j) + dp[i+1][j+1];

                dp[i][j] = Math.min(down, dg);
            }
        }

        return dp[0][0];
    }
}