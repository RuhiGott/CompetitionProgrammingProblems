class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        List<List<String>> solution = new ArrayList<>();

        Map<String, Integer> map = new HashMap<>();

        for (String s : strs) {
            String anagram = getAnagram(s);
            
            if (map.containsKey(anagram)) {
                solution.get(map.get(anagram)).add(s);
            } else{
                List<String> newList = new ArrayList<>();
                newList.add(s);
                solution.add(newList);
                map.put(anagram, solution.size() - 1);
            }
        }

        return solution;
    }

    private String getAnagram(String s) {
        int[] list = new int[26];

        for (char c : s.toCharArray()) {
            list[c - 'a']++;
        }

        return Arrays.toString(list);
    }
}
