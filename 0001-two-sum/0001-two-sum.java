class Solution {
    public int[] twoSum(int[] nums, int target) {
        int result[] = new int[2];
        result[0] = result[1] = -1;

        //you may not use the same element twice
        HashMap<Integer, Integer> map = new HashMap<>();

        for(int i=0; i<nums.length; i++){
            int more = target - nums[i];
            if(map.containsKey(more)){
                result[0] = map.get(more);
                result[1] = i;
                return result;
            }

            map.put(nums[i], i);
        }
        return result;
    }
}