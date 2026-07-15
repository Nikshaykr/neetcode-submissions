class Solution {
    public String minWindow(String s, String t) {
        if (s == null || s.isEmpty() || t == null || t.isEmpty() || t.length() > s.length()) 
            return "";

        int[] map = new int[128];
        int count = t.length(), start = 0, end = 0, minLength = Integer.MAX_VALUE, startIndex = 0;

        // populate the map according to t
        for (char ch : t.toCharArray()) map[ch]++;

        // start the loop to find the string that has all the elements of t in it
        char[] chS = s.toCharArray();
        while (end < chS.length){
            // if char at end is in t then decrement count that means we found a required char
            if (map[chS[end++]]-- > 0) count--;

            // shrink the window until count is 0, thi will be executed when substring
            // with all character are found
            while (count == 0){
                int currWindowLength = end - start;
                if (currWindowLength < minLength){
                    minLength = currWindowLength;
                    startIndex = start;
                }

                // start shrinking the window and stop when a char goes missing
                if (map[chS[start++]]++ == 0) count++;
            }
        }
        return minLength == Integer.MAX_VALUE ? "" : s.substring(startIndex, startIndex + minLength);
    }
}
