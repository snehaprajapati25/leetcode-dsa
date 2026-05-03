class Solution {
    // public int f(int[][] matrix, int i, int j) {
    //     int m = matrix[0].length;
    //     if (j < 0 || j >= m)
    //         return Integer.MAX_VALUE; //if col goes out of matrix

    //     if (i == 0)
    //         return matrix[0][j];

    //     int up = f(matrix, i - 1, j);
    //     int ld = f(matrix, i - 1, j - 1);
    //     int rd = f(matrix, i - 1, j + 1);

    //     int min = Math.min(up, Math.min(ld, rd));

    //     if (min == Integer.MAX_VALUE)
    //         return Integer.MAX_VALUE;

    //     return matrix[i][j] + min;

    // }

    public int minFallingPathSum(int[][] matrix) {
        int n = matrix.length;
        int m = matrix[0].length;

        int dp[][] = new int[n][m];

        for(int j=0; j<m; j++){
            dp[0][j] = matrix[0][j];
        }

        for(int i=1; i<n; i++){
            for(int j=0; j<m; j++){
                int up = matrix[i][j] + dp[i-1][j];
                
                int ld = matrix[i][j];
                if(j-1>=0) ld += dp[i-1][j-1];
                else ld += 1e8;

                int rd = matrix[i][j];
                if(j+1<m) rd+= dp[i-1][j+1];
                else rd += 1e8;

                dp[i][j] = Math.min(up, Math.min(ld, rd));
            }
        }

        int min = Integer.MAX_VALUE;

        for (int j = 0; j < m; j++) {
            min = Math.min(min,dp[n-1][j]); //since we can get answer on last row from any col
        }
        return min;
    }
}