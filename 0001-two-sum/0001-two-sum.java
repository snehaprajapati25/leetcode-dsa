class Solution {
    public int[] twoSum(int[] nums, int target) {
        HashMap<Integer,Integer> map = new HashMap<>();
        int result[] = new int[2];
        int n= nums.length;

        for(int i=0; i<n; i++){
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