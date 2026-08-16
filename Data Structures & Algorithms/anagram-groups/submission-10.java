class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> map = new HashMap<>();

        for (String s : strs) {
            String anagram = getAnagram(s);
            
            if (map.containsKey(anagram)) {
                map.get(anagram).add(s);
            } else{
                List<String> newList = new ArrayList<>();
                newList.add(s);
                map.put(anagram, newList);
            }
        }

        return new ArrayList<>(map.values());
    }

    private String getAnagram(String s) {
        int[] list = new int[26];

        for (char c : s.toCharArray()) {
            list[c - 'a']++;
        }

        StringBuilder anagram = new StringBuilder();

        for (int count : list) {
            anagram.append(count).append(",");
        }

        return anagram.toString();
    }
}
