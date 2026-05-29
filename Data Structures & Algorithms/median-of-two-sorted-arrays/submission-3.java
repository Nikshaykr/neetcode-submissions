class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int m = nums1.length, n = nums2.length;
        int size = m + n, index1 = size / 2 - 1, index2 = size / 2;
        int element1 = -1, element2 = -1;
        int i = 0, j = 0, k = 0;

        while (i < m && j < n){
            if (nums1[i] < nums2[j]){
                if (index1 == k) element1 = nums1[i];
                if (index2 == k) element2 = nums1[i];
                k++;
                i++;
            }
            else {
                if (index1 == k) element1 = nums2[j];
                if (index2 == k) element2 = nums2[j];
                k++;
                j++;
            }
        }

        while (i < m){
            if (index1 == k) element1 = nums1[i];
                if (index2 == k) element2 = nums1[i];
                k++;
                i++;
        }

        while (j < n){
            if (index1 == k) element1 = nums2[j];
                if (index2 == k) element2 = nums2[j];
                k++;
                j++;
        }

        if (size % 2 == 1) return element2;
        return (element1 + element2) / 2.0;
    }
}
