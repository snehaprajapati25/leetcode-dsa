class Solution {
    public List<Integer> findDuplicates(int[] nums) {
        List<Integer> ans = new ArrayList<>();

        // approach
        // For each number x, go to index x - 1
        // If value at that index is negative, x is a duplicate
        // Otherwise, make it negative to mark visited  TC- O(n), SC- O(1)

        for(int i=0; i<nums.length; i++){
            int idx = Math.abs(nums[i]) - 1;

            if(nums[idx] < 0){
                ans.add(idx + 1);
            }else{
                nums[idx] = -nums[idx];
            }
        }
        return ans;
    }
}