class Solution {
    public int rob(int[] nums) {
        int prev = nums[0];
        int prev2 = 0;

        for(int i=1; i<nums.length; i++){
            int take = nums[i] ;
            if(i>1) take += prev2;
            int notTake = 0 + prev;

            int cur= Math.max(take, notTake);
            prev2 = prev;
            prev = cur;
        }

        return prev;
    }
}