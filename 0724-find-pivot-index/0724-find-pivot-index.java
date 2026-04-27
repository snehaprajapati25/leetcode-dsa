class Solution {
    public int pivotIndex(int[] nums) {
        int total = 0;
        for(int i: nums){
            total += i;
        }

        int leftSum = 0;
        for(int i=0; i<nums.length; i++){
            //pivot or cur ele = nums[i]
            //leftSum = sum of elements before index i
            // rightSum = totalSum - leftSum - current element
            // This ensures correct pivot comparison at every index
            int rightSum = total - leftSum - nums[i];

            if(rightSum == leftSum){
                return i;
            }

            leftSum += nums[i];
        }

        return -1;
    }
}