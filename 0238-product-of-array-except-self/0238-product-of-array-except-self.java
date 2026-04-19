class Solution {
    public int[] productExceptSelf(int[] nums) {
        int suffixSum[] = new int[nums.length];
        int prefixSum[] = new int[nums.length];

        prefixSum[0] = 1;
        for(int i=1; i<nums.length; i++){
            prefixSum[i] = nums[i-1]*prefixSum[i-1];
        }

        suffixSum[nums.length-1] = 1;
        for(int i=nums.length-2; i>=0; i--){
            suffixSum[i] = nums[i+1]*suffixSum[i+1];
        }

        int answer[] = new int[nums.length];
        for(int i=0; i<nums.length; i++){
            answer[i] = prefixSum[i]*suffixSum[i];
        }

        return answer;
    }
}