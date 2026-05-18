class Solution {
    public int fib(int n) {
        int prev = 1;
        int prev2 = 0;

        if(n == 0)return 0;

        for(int i=2; i<=n; i++){
            int fib = prev+prev2;

            prev2 = prev;
            prev = fib;
        }

        return prev;
    }
}