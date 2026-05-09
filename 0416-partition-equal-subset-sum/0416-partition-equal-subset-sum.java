class Solution {
    boolean f(int n, int k, int[] arr){
        boolean[] prev = new boolean[k+1];
        prev[0] = true; //sum = 0 can be made with empty set
        if(arr[0]<=k)prev[arr[0]] = true;

        for(int ind=1; ind<n; ind++){
            boolean[] cur = new boolean[k+1];
            cur[0] = true;

            for(int target=1; target<=k; target++){
                boolean notTake = prev[target];

                boolean take = false;
                if(arr[ind] <= target){
                    take = prev[target-arr[ind]];
                }

                cur[target] = take || notTake;
            }

            prev = cur;
        }

        return prev[k];
    }

    public boolean canPartition(int[] nums) {
        int totalSum = 0;

        for(int i: nums){
            totalSum += i;
        }

        if(totalSum % 2 != 0)return false; //if odd sum subset wth equal sum not possible
        int target = totalSum / 2;
        return f(nums.length, target, nums);
    }
}