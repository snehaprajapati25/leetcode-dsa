class Solution {
    public int findMin(int[] arr) {
        int low = 0;
        int high = arr.length-1;

        while(low < high){
            int mid = (low + high) / 2;

            // because the minimum element is in the right half of the array
            if(arr[mid] > arr[high]){
                low = mid+1;
            }
            //because the minimum element is in the left half of the array
            else if(arr[mid] < arr[high]) {
                high = mid;
            }else{
                high--; //deal wth duplicatees
            }
        }return arr[low];
}}