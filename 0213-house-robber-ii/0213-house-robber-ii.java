class Solution {
    public int f(int[] nums, int si, int ei){
        int dp[] = new int[nums.length];
        dp[si] = nums[si];

        for(int i=si+1; i<=ei; i++){
            int notRob = dp[i-1];
            int rob  = nums[i];

            if(i> si+1) rob += dp[i-2];

            dp[i] =Math.max(rob, notRob); 
        }

        return dp[ei];
    }
    public int rob(int[] nums) {
        if(nums.length == 1)return nums[0];
        return Math.max(f(nums, 0, nums.length-2),f(nums, 1, nums.length-1));
    }
}