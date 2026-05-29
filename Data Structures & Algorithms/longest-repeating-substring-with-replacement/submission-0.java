class Solution {
    public int characterReplacement(String s, int k) {
        int[] freq = new int[26];
        int left = 0, maxFreq = 0, maxWindow = 0;

        for (int right = 0; right < s.length(); right++){
            freq[s.charAt(right) - 'A']++;

            maxFreq = Math.max(freq[s.charAt(right) - 'A'], maxFreq);
            int currentWindow = right - left + 1;

            if (currentWindow - maxFreq > k){
                freq[s.charAt(left) - 'A']--;
                left++;
            }
            currentWindow = right - left + 1;
            maxWindow = Math.max(maxWindow, currentWindow);
        }
        return maxWindow;
    }
}
