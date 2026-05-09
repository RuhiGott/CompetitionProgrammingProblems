class Solution {
    public boolean isAnagram(String s, String t) {
        Map<Character, Integer> map = new HashMap<>();

        if (s.length() != t.length()) {
            return false;
        }

        for (int i = 0; i < s.length(); i++) {
            char letter = s.charAt(i);
            if (map.containsKey(letter)) {
                map.put(letter, map.get(letter) + 1);
            } else {
                map.put(letter, 1);
            }
        }

        for (int i = 0; i < t.length(); i++) {
            char letter = t.charAt(i);
            if (!map.containsKey(letter)) {
                return false;
            } 

            int count = map.get(letter);
            if (count <= 0) {
                return false;
            } else {
                map.put(letter, count - 1);
            }
        }

        for (int num : map.values()) {
            if (num != 0) {
                return false;
            }
        }

        return true;
    }
}
