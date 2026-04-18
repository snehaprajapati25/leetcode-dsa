class Solution {
    public int[] twoSum(int[] nums, int target) {
    int ans[] = new int[2]; 
       HashMap<Integer,Integer>map = new HashMap<>();
       int result = 0;

       for(int i=0; i<nums.length; i++){
           int x = target - nums[i];
           if(!map.containsKey(x)){
             map.put(nums[i], i);
           }else{
             ans[0] = map.get(x);
             ans[1] = i;
             return ans;
           }
        }

        return ans;
    }
}