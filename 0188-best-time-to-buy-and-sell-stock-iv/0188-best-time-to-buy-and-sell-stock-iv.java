class Solution {
    public int maxProfit(int k, int[] prices) {
        int n = prices.length;
        int after[] = new int[2*k+1];

        //if n == 4 || transNo == 2k it will return 0 but no need to write this

        for(int ind=n-1; ind>=0; ind--){
            int cur[] = new int[2*k+1];
            for(int transNo = 2*k-1; transNo>=0; transNo--){
                if(transNo % 2 == 0){
                    cur[transNo] = Math.max(-prices[ind] + after[transNo+1], 0 + after[transNo]);
                }else{
                    cur[transNo] = Math.max(prices[ind] + after[transNo+1], 0 + after[transNo]);
                }
            }

            after = cur;
        }

        return after[0];
    }
}