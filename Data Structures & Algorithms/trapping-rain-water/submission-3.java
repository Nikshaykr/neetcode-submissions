class Solution {
    public int trap(int[] height) {
        int n = height.length;
        if (n == 0 || height == null) return 0;

        int l = 0, r = n - 1, result = 0;
        int leftMax = height[l], rightMax = height[r];

        while (l < r){
            if (leftMax < rightMax){
                l++;
                leftMax = Math.max(leftMax, height[l]);
                result += leftMax - height[l];
            } else {
                r--;
                rightMax = Math.max(rightMax, height[r]);
                result += rightMax - height[r];
            }
        }

        return result;
    }
}
