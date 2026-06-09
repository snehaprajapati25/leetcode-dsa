class Solution {
    public int lcs(String s1, String s2, int n, int m){
        int prev[] = new int[m+1];

        // for(int i=0; i<=n; i++)dp[i][0] = 0;

        for(int j=0; j<=m; j++)prev[j] = 0;

        for(int i=1; i<=n; i++){
            int cur[] = new int[m+1];
            for(int j=1; j<=m; j++){
                if(s1.charAt(i-1) == s2.charAt(j-1)){
                    cur[j] = 1 + prev[j-1];
                }else{
                    cur[j] = Math.max(prev[j], cur[j-1]);
                }
            }
            prev = cur;
        }

        return prev[m];
    }

    public int minDistance(String word1, String word2) {
        int n = word1.length();
        int m = word2.length();

        return n+m - 2*lcs(word1, word2, n, m);
    }
}