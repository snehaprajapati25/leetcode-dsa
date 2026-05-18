class Solution {
    public int adjacentHouses(int si, int ei, int nums[]){
        int prev = nums[si];
        int prev2 = 0;

        for(int i=si+1; i<ei; i++){
            int notTake = 0 + prev;
            int take = nums[i] + prev2;  

            int cur = Math.max(take, notTake);

            prev2 = prev;
            prev = cur;
        }

        return prev;
    }
    public int rob(int[] nums) {
        int n = nums.length;
        if(n == 1)return nums[0];
        return Math.max(adjacentHouses(0, n-1, nums), adjacentHouses(1, n, nums));
    }
}