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

        boolean prev[] = new boolean[m + 1];
        prev[0] = true;

        //empty pattern p cannnot match wth non-empty string
        // for (int i = 1; i <= n; i++) {
        //     prev[0] = false;
        // }

        //empty string can match wth p if it contains *
        for (int j = 1; j <= m; j++) {
            prev[j] = isAllStars(p, j);
        }

        for (int i = 1; i <= n; i++) {
            boolean cur[] = new boolean[m + 1];
            cur[0] = false;
            for (int j = 1; j <= m; j++) {
                if (s.charAt(i - 1) == p.charAt(j - 1) || p.charAt(j - 1) == '?') {
                    cur[j] = prev[j - 1];
                } else if (p.charAt(j - 1) == '*') {
                    cur[j] = prev[j] || cur[j - 1];
                } else {
                    cur[j] = false;
                }
            }

            prev = cur;
        }

        return prev[m];
    }
}