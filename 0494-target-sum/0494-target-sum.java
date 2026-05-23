class Solution {
    public int findTargetSumWays(int[] nums, int target) {
        return countWays(nums.length, nums, target);
    }

    public int countWays(int n, int[] nums, int d){
        int total = 0;
        for(int i: nums){
            total += i;
        }

        if(total-d < 0 || (total-d)%2 != 0)return 0;

        return f(n, nums, (total-d)/2);
    }

    public int f(int n, int[] nums, int tar){
        int prev[] = new int[tar+1];

        if(nums[0] == 0)prev[0] = 2;
        else prev[0] = 1;

        if(nums[0] != 0 && nums[0] <=tar)prev[nums[0]] = 1;

        for(int ind=1; ind<n; ind++){
            int cur[] = new int[tar+1];
            for(int sum=0; sum<=tar; sum++){
                int notPick = prev[sum];
                int pick = 0;

                if(nums[ind] <= sum)pick = prev[sum - nums[ind]];

                cur[sum] = pick+notPick;
            }
            prev = cur;
        }

        return prev[tar];
    }
}