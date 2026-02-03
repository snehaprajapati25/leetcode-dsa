class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
       int ans[] =  merge(nums1, nums2);
       double median = 0;

       if(ans.length % 2 != 0){
        median = ans[ans.length/2];
       }else{
        median = (ans[ans.length/2] + ans[ans.length/2 - 1]) / 2.0;
       }
       return median;
    }

    public int[] merge(int[] nums1, int[] nums2){
        int res[] = new int[nums1.length + nums2.length];
        int i = 0, j = 0, k = 0;

        while(i<nums1.length && j<nums2.length){
            if(nums1[i] < nums2[j]){
                res[k++] = nums1[i++];
            }else{
                res[k++] = nums2[j++];
            }
        }

        while(i<nums1.length){
             res[k++] = nums1[i++];
        }

        while(j<nums2.length){
             res[k++] = nums2[j++];
        }

        return res;

    }
}