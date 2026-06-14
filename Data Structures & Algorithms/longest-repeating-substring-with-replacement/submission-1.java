class Solution {
    public int characterReplacement(String s, int k) {
        int[] freq = new int[26];
        int left = 0, maxFreq = 0, maxWindow = 0;

        for (int right = 0; right < s.length(); right++){
            // Update the freq of the current char
            freq[s.charAt(right) - 'A']++;

            // Update the maxFreq and calculate the current window length
            maxFreq = Math.max(maxFreq, freq[s.charAt(right) - 'A']);
            int currentWindow = right - left + 1;

            // If the window is not valid, then shrink the window
            if (currentWindow - maxFreq > k){
                freq[s.charAt(left) - 'A']--;
                left++;
            }

            // Calculate the new currentWindow and update the maxWindow
            currentWindow = right - left + 1;
            maxWindow = Math.max(maxWindow, currentWindow);
        }
        return maxWindow;   
    }
}
