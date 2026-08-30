class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> map = new HashMap<>();

        for (String s : strs) {
            String anagram = getAnagram(s);

            if (!map.containsKey(anagram)) {
                map.put(anagram, new ArrayList<>());
            }

            map.get(anagram).add(s);
        }

        return new ArrayList<>(map.values());
        
    }

    private String getAnagram(String s) {
        int[] anagram = new int[26];

        for (char c : s.toCharArray()) {
            anagram[c - 'a']++;
        }

        return Arrays.toString(anagram);
    }
}
