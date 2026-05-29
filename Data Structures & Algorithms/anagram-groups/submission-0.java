class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> map = new HashMap<>();

        for (var word : strs){
            char[] charArray = word.toCharArray();
            Arrays.sort(charArray);
            String sortedStr = new String(charArray);

            map.putIfAbsent(sortedStr, new ArrayList<>());

            map.get(sortedStr).add(word);
        }
        return new ArrayList<>(map.values());
    }
}
