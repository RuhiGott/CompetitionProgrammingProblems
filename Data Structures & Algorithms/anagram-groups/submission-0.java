class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        
        Map<String, List<String>> map = new HashMap<>();

        for (String str : strs) {
            int[] counts = new int[26];
            for (int i = 0; i < str.length(); i++) {
                counts[str.charAt(i) - 'a']++;
            }

            String countsStr = Arrays.toString(counts);

            if (map.containsKey(countsStr)) {
                map.get(countsStr).add(str);
            } else {
                List<String> newList = new ArrayList<>();
                newList.add(str);
                map.put(countsStr, newList);
            }

        }

        return new ArrayList<>(map.values());
    }
}
