class Solution {
    public int characterReplacement(String s, int k) {
        if (s.length() == 1) {
            return 1;
        }

        int left = 0;
        int right = 1;

        int[] letters = new int[26];
        letters[s.charAt(0) - 'A']++;

        int maxFrequency = 1;
  
        int length = 1;
        int maxLength = 1;

        while (right < s.length()) {
            length++;
            char rightLetter = s.charAt(right);
            letters[rightLetter  - 'A']++;
            
            if (letters[rightLetter  - 'A'] > maxFrequency) {
                maxFrequency = letters[rightLetter  - 'A'];
            }

            if (length - maxFrequency > k) {
                maxLength = Math.max(maxLength, length - 1);
                letters[s.charAt(left)  - 'A']--;
                left++;
                length--;
            }

            right++;
            
         }

         return Math.max(maxLength, length);         
    }
}
