class Solution { 
    public List<List<String>> groupAnagrams(String[] strs) { 
        Map<String, List<String>> map = new HashMap<>();
        for (String s : strs) { 
            char[] cArray = s.toCharArray();   
            Arrays.sort(cArray);
            String anagram = new String(cArray);

            if (!map.containsKey(anagram)) { 
                map.put(anagram, new ArrayList<>());
            } 

            map.get(anagram).add(s);
        } 
        
        return new ArrayList<>(map.values());
    } 
}