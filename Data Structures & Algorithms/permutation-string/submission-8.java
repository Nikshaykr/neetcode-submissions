class Solution {
    public boolean checkInclusion(String s1, String s2) {
        // edge cases
        if (s1.length() > s2.length()) return false;

        // initialize two hash array to keep track of freq of char of both strings
        int[] first = new int[26], second = new int[26];

        // populate first array based on s1
        for (char ch : s1.toCharArray()) first[ch - 'a']++;

        int winLength = s1.length();

        for (int i = 0; i < s2.length(); i++){
            second[s2.charAt(i) - 'a']++;

            if (i >= winLength - 1){
                if (matches(first, second)) return true;
                second[s2.charAt(i - winLength + 1) - 'a']--;
            }
        }

        return false;
    }

    public boolean matches(int[] first, int[] second) {
        for (int i = 0; i < 26; i++){
            if (first[i] != second[i]) return false;
        }
        return true;
    }
}
