class Solution {
    public int maxNonAdjacentSum(int[] nums,int start, int end){
        int prev = nums[start];
        int prev2 = 0;

        for(int i=start+1; i<end; i++){
            int take = nums[i];

            if(i>1){
                take += prev2;
            }

            int notTake = 0 + prev;

            int curi = Math.max(take, notTake);
            prev2 = prev;
            prev = curi;
        }

        return prev;
    }

    public int rob(int[] nums) {
       if(nums.length == 1)return nums[0];
       return Math.max(maxNonAdjacentSum(nums, 0, nums.length-1), maxNonAdjacentSum(nums, 1, nums.length));
    }
}