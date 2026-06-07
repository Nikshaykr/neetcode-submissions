class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> map = new HashMap<>();

        for(var word : strs){
            char[] sWord = word.toCharArray();
            Arrays.sort(sWord);

            String key = Arrays.toString(sWord);

            map.computeIfAbsent(key, k -> new ArrayList<>()).add(word);
        }
        return new ArrayList<>(map.values());
    }
}
