class Solution {
    public int longestConsecutive(int[] nums) {
        int longest = 0;

        Map<Integer, Boolean> map = new HashMap<>();
        for (int num : nums) map.put(num, Boolean.FALSE);

        for (int num : nums){
            var length = 1;

            int nextNum = num + 1;
            while (map.containsKey(nextNum) && map.get(nextNum) == false){
                length++;
                map.put(nextNum, true);
                nextNum++;
            }

            int prevNum = num - 1;
            while (map.containsKey(prevNum) && map.get(prevNum) == false){
                length++;
                map.put(prevNum, true);
                prevNum--;
            }

            longest = Math.max(longest, length);
        }
        return longest;
    }
}
