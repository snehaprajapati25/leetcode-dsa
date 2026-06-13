class Solution {
    public int maxProfit(int[] prices) {
        int n = prices.length;
        int after[][] = new int[2][3];

        for(int ind=n-1; ind>=0; ind--){
            int cur[][] = new int[2][3];
            for(int buy=0; buy<=1; buy++){
                for(int cap=1; cap<=2; cap++){
                    if(buy == 1){ //buy
                        cur[buy][cap] = Math.max(-prices[ind] + after[0][cap], 0 + after[1][cap]);
                    }else{
                        cur[buy][cap] = Math.max(prices[ind] + after[1][cap-1], 0 + after[0][cap]);
                    }
                }
            }

            after = cur;
        }

        return after[1][2];
    }
}