class Solution {
    public boolean isAnagram(String s, String t) {
        int[] counts = new int[26];
        
        if (s.length() != t.length()) {
            return false;
        }

        for (int i = 0; i < s.length(); i++) {
            counts[s.charAt(i) - 'a']++;
        }

        for (int i = 0; i < t.length(); i++) {
            char letter = t.charAt(i);

            if (counts[letter - 'a'] == 0) {
                return false;
            } 

            counts[letter - 'a']--;
        }

        return true;
    }
}
