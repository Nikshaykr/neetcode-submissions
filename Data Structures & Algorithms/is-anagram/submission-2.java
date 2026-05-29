class Solution {
    public boolean isAnagram(String s, String t) {
        Map<Character, Integer> map = new HashMap<>();
        
        for (var ch : s.toCharArray()){
            if (map.containsKey(ch)) map.put(ch, map.get(ch) + 1);
            else map.put(ch, 1);
        }

        for (var ch : t.toCharArray()){
            if (map.containsKey(ch)) map.put(ch, map.get(ch) - 1);
            else return false;
        }

        for (var key : map.keySet()){
            if (map.get(key) != 0) return false;
        }
        return true;
    }
}
