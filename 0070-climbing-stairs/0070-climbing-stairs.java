class Solution {
    public int climbStairs(int n) {
        if(n == 0 || n == 1)return n;

        int prev = 1;
        int prev2 = 0;

        for(int i=1; i<=n; i++){
            int ways = prev + prev2;

            prev2 = prev;
            prev = ways;
        }

        return prev;
    }
}