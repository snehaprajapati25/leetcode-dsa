class Solution {
    public boolean containsDuplicate(int[] nums) {
        HashMap<Integer,Integer>map = new HashMap<>();

        for(int i: nums){
            if(map.containsKey(i) && map.get(i) >= 1){
                return true;
            }
            map.put(i, map.getOrDefault(i, 0)+1);
        }

        return false;
    }
}