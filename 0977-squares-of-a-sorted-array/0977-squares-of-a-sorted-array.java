class Solution {
    public int[] sortedSquares(int[] nums) {
        int result[] = new int[nums.length];

        int left = 0;
        int right = nums.length-1;
        int i = nums.length-1;

        while(i>=0){
            int leftSq = nums[left]*nums[left];
            int rightSq = nums[right]*nums[right];

            if(leftSq > rightSq){
                result[i--] = leftSq;
                left++;
            }else{
                result[i--] = rightSq;
                right--;
            }
        }

        return result;
    }
}