class Solution {
    public boolean checkInclusion(String s1, String s2) {
        int[] first = new int[26], second = new int[26];

        // edge cases
        if (s1.length() > s2.length()) return false;

        // populate first index based on s1 char count
        for (char ch : s1.toCharArray()) first[ch - 'a']++;

        // initialize windowLength
        int windowLen = s1.length();

        // iterate through s2 until you get a valid window and 
        // compare the freq of all char of both strings
        for(int i = 0; i < s2.length(); i++){
            second[s2.charAt(i) - 'a']++;

            // when window found ie i is at the last index of window
            if (i >= windowLen - 1){
                if (matches(first, second)) return true;
                second[s2.charAt(i - windowLen + 1) - 'a']--;
            }
        }
        return false;
    }

    public boolean matches(int[] first, int[] second){
        for (int i = 0; i < 26; i++)
            if (first[i] != second[i]) return false;
        
        return true;
    }
}
