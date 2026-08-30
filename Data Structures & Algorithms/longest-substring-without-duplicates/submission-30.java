class Solution {
    public int lengthOfLongestSubstring(String s) {
        Map<Character, Integer> map = new HashMap<>();

        int max = 0;
        
        int l = 0;
        int r = 0;

        while (r < s.length()) {
            
            char c = s.charAt(r);
    
            if (map.containsKey(c)) {
                l = Math.max(l, map.get(c) + 1);
            }

            max = Math.max(r - l + 1, max);
            map.put(c, r);
            r++;
        }

        return max;
    }
}
