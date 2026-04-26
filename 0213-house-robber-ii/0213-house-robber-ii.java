class Solution {
    public int rob(int[] nums) {
        int n = nums.length;
        if(n == 1)return nums[0];
        return Math.max(maxSum(nums, 0, n-1) , maxSum(nums, 1, n));
    }

    public int maxSum(int[] nums, int si, int ei){
        int curSum = 0;
        int prev = nums[si];
        int prev2 = 0;

        for(int i=si+1; i<ei; i++){
            int take = nums[i] + prev2;
            int notTake = 0 + prev;

            curSum = Math.max(take, notTake);
            prev2 = prev;
            prev = curSum;
        }

        return prev;
    }
}