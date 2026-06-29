class Solution {
    public int[] twoSum(int[] numbers, int target) {
        int left = 0, right = numbers.length - 1;

        while (left < right){
            int currSum = numbers[left] + numbers[right];

            if (currSum == target) return new int[] {++left, ++right};

            if (currSum > target) right--;
            else left++;
        }
        return new int[2];
    }
}
