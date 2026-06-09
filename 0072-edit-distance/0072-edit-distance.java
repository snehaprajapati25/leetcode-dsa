class Solution {
    // public int f(int i, int j, String s1, String s2){
    //     if(i < 0) return j+1;
    //     if(j< 0) return i+1;

    //     if(s1.charAt(i) == s2.charAt(j)){
    //         return f(i-1, j-1, s1, s2);
    //     }

    //     return Math.min(1 + f(i, j-1, s1, s2), Math.min(1 + f(i-1, j, s1, s2), 1 + f(i-1, j-1, s1, s2)));
    // }

    public int minDistance(String word1, String word2) {
        int n = word1.length();
        int m = word2.length();

        int prev[] = new int[m+1];

        // for(int i=0; i<=n; i++)dp[i][0] = i;
        for(int j=0; j<=m; j++)prev[j] = j;

        for(int i=1; i<=n; i++){
            int cur[] = new int[m+1];
            cur[0] = i;
            for(int j=1; j<=m; j++){
                if(word1.charAt(i-1) == word2.charAt(j-1)){
                cur[j] =  prev[j-1];
                }else{
                    cur[j] = Math.min(1 + cur[j-1], Math.min(1 + prev[j], 1 + prev[j-1]));
                }
            }  

            prev = cur;  
        }       
        
        return prev[m];
    }
}