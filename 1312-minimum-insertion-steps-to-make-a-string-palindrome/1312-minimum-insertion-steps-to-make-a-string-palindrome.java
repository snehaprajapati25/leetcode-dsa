class Solution {
    public int palindromicSubsequence(String s1, String s2){
        int n = s1.length();
        int m = s2.length();

        int prev[] = new int[m+1];
        // for(int i=0; i<=n; i++)dp[i][0] = 0;
        // for(int j=0; j<=m; j++)dp[0][j] = 0;

        for(int i=1; i<=n; i++){
            int cur[] = new int[m+1];
            for(int j=1; j<=m; j++){
                if(s1.charAt(i-1) == s2.charAt(j-1)){
                    cur[j] = 1+prev[j-1];
                }else{
                    cur[j] = Math.max(prev[j], cur[j-1]);
                }
            }
            prev = cur;
        }

        return prev[m];
    }

    public int minInsertions(String s) {
        String t = new StringBuilder(s).reverse().toString();
        int n = s.length();
        int len = palindromicSubsequence(s,t);

        return n-len;
    }
}