class Solution {
    public String minWindow(String s, String t) {
        if (s == null || s.isEmpty() || t == null || t.isEmpty() || s.length() < t.length())
            return "";

        int[] map = new int[128];
        int count = t.length(), start = 0, end = 0, minLength = Integer.MAX_VALUE, startIndex = 0;

        for (char ch : t.toCharArray()) map[ch]++;

        char[] chS = s.toCharArray();
        while (end < chS.length){
            if (map[chS[end++]]-- > 0) count--;

            while(count == 0){
                int currWindow = end - start;
                if (currWindow < minLength) {
                    minLength = currWindow;
                    startIndex = start;
                }

                if (map[chS[start++]]++ == 0) count++;
            }
        }
        return minLength == Integer.MAX_VALUE ? "" : s.substring(startIndex, startIndex + minLength);
    }
}
