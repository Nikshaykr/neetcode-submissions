class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int m = nums1.length, n = nums2.length;
        int size = m + n, i = 0, j = 0, k = 0;
        int[] merged = new int[size];

        while (i < m && j < n){
            if (nums1[i] < nums2[j]) merged[k++] = nums1[i++];
            else merged[k++] = nums2[j++];
        }

        while (i < m){
            merged[k++] = nums1[i++];
        }

        while (j < n){
            merged[k++] = nums2[j++];
        }

        if (size % 2 == 1) return merged[size / 2];
        return (merged[size / 2 - 1] + merged[size / 2]) / 2.0;
    }
}
