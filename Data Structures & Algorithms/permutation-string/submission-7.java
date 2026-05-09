class Solution {
    public boolean checkInclusion(String s1, String s2) {
        if (s2.length() < s1.length()) {
            return false;
        }

        int[] s1Chars = new int[26];
        int[] s2Chars = new int[26];

        for (int i = 0; i < s1.length(); i++) {
            s1Chars[s1.charAt(i) - 'a']++;
        }

        for (int i = 0; i < s1.length(); i++) {
            s2Chars[s2.charAt(i) - 'a']++;
        }

        int left = 0;
        int right = s1.length() - 1;

        if (Arrays.equals(s1Chars, s2Chars)) {
            return true;
        }

        while (right < s2.length() - 1) {

            s2Chars[s2.charAt(left) - 'a']--;
            s2Chars[s2.charAt(right + 1) - 'a']++;

            left++;
            right++;

            if (Arrays.equals(s1Chars, s2Chars)) {
                return true;
            }
        }

        return false;


    }
}
