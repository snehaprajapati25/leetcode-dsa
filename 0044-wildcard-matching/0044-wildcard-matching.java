class Solution {
    public boolean isAllStars(String p, int i){
        for(int j=1; j<=i; j++){
            if(p.charAt(j-1) != '*')return false;
        }
        return true;
    }

    public boolean isMatch(String s, String p) {
        int n = s.length();
        int m = p.length();

        boolean dp[][] = new boolean[n + 1][m + 1];
        dp[0][0] = true;

        //empty pattern p cannnot match wth non-empty string
        for (int i = 1; i <= n; i++) {
            dp[i][0] = false;
        }

        //empty string can match wth p if it contains *
        for (int j = 1; j <= m; j++) {
            dp[0][j] = isAllStars(p, j);
        }

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++) {
                if (s.charAt(i - 1) == p.charAt(j - 1) || p.charAt(j - 1) == '?') {
                    dp[i][j] = dp[i - 1][j - 1];
                } else if (p.charAt(j - 1) == '*') {
                    dp[i][j] = dp[i - 1][j] || dp[i][j - 1];
                } else {
                    dp[i][j] = false;
                }
            }
        }

        return dp[n][m];
    }
}