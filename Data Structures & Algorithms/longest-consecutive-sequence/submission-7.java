class Solution {
    public int longestConsecutive(int[] nums) {
        int longest = 0;

        Set<Integer> set = new HashSet<>();
        for (int num : nums) set.add(num);

        for (int num : nums){
            if (!set.contains(num - 1)){
                int curr = num, count = 1;

                while (set.contains(curr + 1)){
                    count++;
                    curr++;
                }
            
                longest = Math.max(longest, count);
            }
        }
        return longest;
    }
}
