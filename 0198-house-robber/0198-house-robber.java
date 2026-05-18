class Solution {
    // public int f(int idx, int[] nums){
    //     if(idx == 0)return nums[idx];

    //     if(idx <0)return 0;

    //     int notTake = 0 + f(idx-1, nums);
    //     int take = nums[idx] + f(idx-2, nums);

    //     return Math.max(take, notTake);
    // }

    public int rob(int[] nums) {
        int dp[] = new int[nums.length];

        dp[0] = nums[0];

        for(int idx=1; idx<nums.length; idx++){
            int notTake = 0 + dp[idx-1];
            int take =  nums[idx];
            if(idx > 1) take += dp[idx-2]; 

            dp[idx] = Math.max(take, notTake);
        }
        return dp[nums.length-1];
    }
}