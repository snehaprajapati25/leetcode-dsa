class Solution {
    public int majorityElement(int[] nums) {
       //“Majority element = the one that survives all pair cancellations”
       //votes = majority element (increase)
       //votes = other elements (decrease)

       int majority = 0;
       int vote = 0;

       for(int i: nums){
        if(vote == 0){
            majority = i;
        }

        if(i == majority){
            vote++;
        }else{
            vote--;
        }
       }
       return majority;
    }
}