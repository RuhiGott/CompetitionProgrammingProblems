class Solution {
    public boolean isAnagram(String s, String t) {
        Map<Character, Integer> map = new HashMap<>();

        if (s.length() != t.length()) {
            return false;
        }

        for (int i = 0; i < s.length(); i++) {
            char letter = s.charAt(i);

            map.put(letter, map.getOrDefault(letter, 0) + 1);
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

        return true;
    }
}
