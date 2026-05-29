class Solution {
    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < nums.length; i++){
            var num = nums[i];
            var diff = target - num;

            if (map.containsKey(diff)) return new int[] {map.get(diff), i};

            map.put(num, i);
        }
        return new int[] {};
    }
}
