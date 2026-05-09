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

        int left = 0;

        while (left < s2.length() && !(s1Chars[s2.charAt(left) - 'a'] > 0)) {
            System.out.println(left);
            left++;
        }

        if (left > s2.length() - s1.length()) {
            return false;
        }

        s2Chars[s2.charAt(left) - 'a']++;
        int right = left + 1;

        if (s1.length() == 1) {
            if (s1Chars[s2.charAt(left) - 'a'] == 1) {
                return true;
            } else {
                return false;
            }
            
        }

        while (right < s2.length()) {
            System.out.println(left);
            char rightLetter = s2.charAt(right);
            s2Chars[rightLetter - 'a']++;

            if (s1Chars[rightLetter - 'a'] == 0 || s2Chars[rightLetter - 'a'] > s1Chars[rightLetter - 'a']) {
                s2Chars[s2.charAt(left) - 'a']--;
                left++;
            } else {
                int length = right - left + 1;
                if (length == s1.length()) {
                    if (Arrays.equals(s1Chars, s2Chars)) {
                        return true;
                    } else {
                        s2Chars[s2.charAt(left) - 'a']--;
                        left++;
                    }
                }
            }

            right++;
        }

        return false;


    }
}
