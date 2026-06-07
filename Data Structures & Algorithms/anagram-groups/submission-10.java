class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> map = new HashMap<>();

        for (var word : strs){
            int [] count = new int[26];

            // Populate count according to the curr word
            for(var ch : word.toCharArray()) count[ch - 'a']++;
            String key = Arrays.toString(count);

            map.computeIfAbsent(key, k -> new ArrayList<>()).add(word);
        }
        return new ArrayList<>(map.values());
    }
}

// Time complexity: worst case scenario = one word is "aaaaaaaaaaaaaaaaaaaaaaaaaaaaaa...100 times"
// complexity would be O(n * k)
// Space complexity: O(n)