class Solution {
    public int[] twoSum(int[] nums, int target) {

        // Brute force approach would be to calculate every possible pair of indices
        // that match the target and return them in a new array

        int[] result = new int[2];

        for (int i = 0; i < nums.length; i++){
            for (int j = i + 1; j < nums.length; j++){
                if (nums[i] + nums[j] == target){
                    result[0] = i;
                    result[1] = j;
                }
            }
        }

        return result;
    }
}
