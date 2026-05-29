class Solution {
    public int search(int[] nums, int target) {
        return search(nums, target, 0, nums.length - 1);
    }

    private int search(int[] nums, int target, int left, int right) {
        if (left > right) return -1;

        if (nums[left] == target) return left;
        if (nums[right] == target) return right;
        
        int mid = left + (right - left) / 2;
        if (nums[mid] == target) return mid;

        // If left half is sorted
        if (nums[mid] > nums[left]){
            if (target <= nums[mid] && target >= nums[left])
                return search(nums, target, left, mid - 1);
            else return search(nums, target, mid + 1, right);
        }
        // If right half is sorted 
        else {
            if (target <= nums[mid] && target >= nums[right])
                return search(nums, target, mid + 1, right);
            else return search(nums, target, left, mid - 1);
        }
    }
}
