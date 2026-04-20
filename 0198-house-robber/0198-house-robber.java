class Solution {
    public int rob(int[] nums) {
        int prevHouse = nums[0];
        int prev2House = 0;

        for(int i=1; i<nums.length; i++){
            int take =  nums[i] + prev2House;
            int notTake = 0 + prevHouse;

            int curHouse = Math.max(take, notTake);

            prev2House = prevHouse;
            prevHouse = curHouse;
        }

        return prevHouse;
    }
}