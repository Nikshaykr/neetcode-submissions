class Solution {
    public int longestConsecutive(int[] nums) {
        int longestLength = 0;
        Map<Integer, Boolean> map = new HashMap<>();
        for (int num : nums) map.put(num, false);
        
        for (var num : nums){
            int currentLength = 1;

            int nextNum = num + 1;
            while (map.containsKey(nextNum) && map.get(nextNum) == false){
                currentLength++;
                map.put(nextNum, true);
                nextNum++;
            }

            int prevNum = num - 1;
            while (map.containsKey(prevNum) && map.get(prevNum) == false){
                currentLength++;
                map.put(prevNum, true);
                prevNum--;
            }

            longestLength = Math.max(longestLength, currentLength);
        }
        return longestLength;
    }
}
