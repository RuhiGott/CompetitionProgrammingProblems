class Solution {
    public int lengthOfLongestSubstring(String s) {
        if (s.length() <= 1) {
            return s.length();
        }

        int left = 0;
        int right = 1;
        
        int maxLength = 1;
        int length = 1;

        Set<Character> set = new HashSet<>();
        set.add(s.charAt(left));

        while (right < s.length()) {
            char letter = s.charAt(right);

            if (set.contains(letter)) {
                maxLength = Math.max(length, maxLength);

                while (s.charAt(left) != letter) {
                    set.remove(s.charAt(left));
                    left++;
                    length--;
                }

                set.remove(s.charAt(left));
                left++;
            }  else {
                length++;
            }

            set.add(letter);
            right++;
        }

        return Math.max(maxLength, length);
    }   
}
