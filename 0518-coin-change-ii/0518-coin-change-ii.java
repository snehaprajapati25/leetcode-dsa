class Solution {
    public int change(int amount, int[] coins) {
        int n = coins.length; 
        int prev[] = new int[amount+1];

        for(int j=0; j<=amount; j++){
            if(j%coins[0] == 0){
                prev[j] = 1;
            }else{
                prev[j] = 0;
            }
        }

        for(int i=1; i<n; i++){
            int cur[] = new int[amount+1];
            for(int j=0; j<=amount; j++){
                int notTake = 0+ prev[j];
                int take = 0;

                if(coins[i] <= j)take = cur[j-coins[i]];
                cur[j] = take + notTake;
            }
            prev = cur;
        }

        return prev[amount];
    }
}