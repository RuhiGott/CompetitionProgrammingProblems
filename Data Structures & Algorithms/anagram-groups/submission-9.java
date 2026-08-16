class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        List<List<String>> solution = new ArrayList<>();

        Map<String, List<String>> map = new HashMap<>();

        for (String s : strs) {
            String anagram = getAnagram(s);
            
            if (map.containsKey(anagram)) {
                map.get(anagram).add(s);
            } else{
                List<String> newList = new ArrayList<>();
                newList.add(s);
                solution.add(newList);
                map.put(anagram, newList);
            }
        }

        return solution;
    }

    private String getAnagram(String s) {
        int[] list = new int[26];

        for (char c : s.toCharArray()) {
            list[c - 'a']++;
        }

        String anagram = "";

        for (int count : list) {
            anagram += count + ",";
        }

        return anagram;
    }
}
