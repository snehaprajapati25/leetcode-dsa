class Solution {
    // public double findMedianSortedArrays(int[] nums1, int[] nums2) {
    //    int ans[] =  merge(nums1, nums2);
    //    double median = 0;

    //    if(ans.length % 2 != 0){
    //     median = ans[ans.length/2];
    //    }else{
    //     median = (ans[ans.length/2] + ans[ans.length/2 - 1]) / 2.0;
    //    }
    //    return median;
    // }

    // public int[] merge(int[] nums1, int[] nums2){
    //     int res[] = new int[nums1.length + nums2.length];
    //     int i = 0, j = 0, k = 0;

    //     while(i<nums1.length && j<nums2.length){
    //         if(nums1[i] < nums2[j]){
    //             res[k++] = nums1[i++];
    //         }else{
    //             res[k++] = nums2[j++];
    //         }
    //     }

    //     while(i<nums1.length){
    //          res[k++] = nums1[i++];
    //     }

    //     while(j<nums2.length){
    //          res[k++] = nums2[j++];
    //     }

    //     return res;

    // }

    public double findMedianSortedArrays(int[] a, int[] b) {
       int n1 = a.length;
       int n2 = b.length;

       if(n1>n2) return findMedianSortedArrays(b, a);
       int low = 0, high = n1;
       int left = (n1 + n2 + 1)/2;
       int n = n1 + n2;

       while(low <= high){
        int mid1 = (low + high)/2;
        int mid2 = left - mid1;

        int l1 = Integer.MIN_VALUE, l2 = Integer.MIN_VALUE;
        int r1 = Integer.MAX_VALUE, r2 = Integer.MAX_VALUE;

        if(mid1 < n1) r1 = a[mid1];
        if(mid2 < n2) r2 = b[mid2];

        if(mid1-1 >= 0)l1 = a[mid1-1];
        if(mid2-1 >= 0)l2 = b[mid2-1];

        if(l1 <= r2 && l2 <= r1){
            if(n % 2 == 1)return Math.max(l1, l2);
            return (double)(Math.max(l1, l2) + Math.min(r1, r2)) / 2.0;
        }else if(l1 > r2) high = mid1 - 1;
        else low = mid1 + 1;
       }
       return 0;
    }
}