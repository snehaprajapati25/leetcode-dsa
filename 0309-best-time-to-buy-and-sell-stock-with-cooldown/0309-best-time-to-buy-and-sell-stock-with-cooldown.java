class Solution {
    public int maxProfit(int[] prices) {
        int n = prices.length;
        // int dp[][] = new int[n+2][2];
        int front2[] = new int[2]; // buy or sell
        int front1[] = new int[2];

        for (int ind = n - 1; ind >= 0; ind--) {
            int cur[] = new int[2];
            //buy == 1
            cur[1] = Math.max(-prices[ind] + front1[0], 0 + front1[1]);

            //buy == 0
            cur[0] = Math.max(prices[ind] + front2[1], 0 + front1[0]);

            front2 = front1;
            front1 = cur;

        }

        return front1[1];

    }
}