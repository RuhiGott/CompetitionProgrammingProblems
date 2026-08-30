class Solution {
    public int lengthOfLongestSubstring(String s) {
        Map<Character, Integer> map = new HashMap<>();

        int max = 0;
        
        int l = 0;
        int r = 0;

        while (r < s.length()) {

            char c = s.charAt(r);
            //System.out.println(c + " l " + l + " r " + r);
    
            if (!map.containsKey(c) || (map.containsKey(c) && map.get(c) < l)) {
                max = Math.max(r - l + 1, max);
            } else {
                l = map.get(c) + 1;
            }

            map.put(c, r);
            r++;
        }

        return max;
    }
}
