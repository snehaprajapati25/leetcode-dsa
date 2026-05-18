class Solution {
    // public int f(int idx, int[] nums){
    //     if(idx == 0)return nums[idx];

    //     if(idx <0)return 0;

    //     int notTake = 0 + f(idx-1, nums);
    //     int take = nums[idx] + f(idx-2, nums);

    //     return Math.max(take, notTake);
    // }

    public int rob(int[] nums) {
        // int dp[] = new int[nums.length];

        int prev = nums[0];
        int prev2 = 0;

        for(int idx=1; idx<nums.length; idx++){
            int notTake = 0 + prev;
            int take =  nums[idx];
            if(idx > 1) take += prev2; 

            int cur = Math.max(take, notTake);

            prev2 = prev;
            prev = cur; 
        }
        return prev;
    }
}