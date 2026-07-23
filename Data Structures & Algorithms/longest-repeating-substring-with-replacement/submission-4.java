class Solution {
    public int characterReplacement(String s, int k) {
        int[] freq = new int[26];

        int left = 0, maxFreq = 0, maxWindow = 0;
        for(int right = 0; right < s.length(); right++){
            // update the freq of newly added char
            freq[s.charAt(right) - 'A']++;

            // update the maxFreq if found any and calculate the currWindow size
            maxFreq = Math.max(maxFreq, freq[s.charAt(right) - 'A']);
            int currWindow = right - left + 1;

            // if total replacable char are more than k then shrink the window as well as the freq
            if (currWindow - maxFreq > k){
                freq[s.charAt(left) - 'A']--;
                left++;
            }

            // calcualte the currWindow and update maxWindow
            currWindow = right - left + 1;
            maxWindow = Math.max(maxWindow, currWindow);
        }
        return maxWindow;
    }
}
