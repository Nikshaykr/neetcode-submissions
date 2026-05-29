class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> map = new HashMap<>();

        for (String str : strs){
            char[] currString = str.toCharArray();
            Arrays.sort(currString);
            String sString = new String(currString);

            map.putIfAbsent(sString, new ArrayList<>());
            
            map.get(sString).add(str);
        }
        return new ArrayList<>(map.values());
    }
}
