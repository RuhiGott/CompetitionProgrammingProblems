class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<List<Integer>, List<String>> map = new HashMap<>();

        for (String str : strs) {
            List<Integer> currLetters = getLettersArray(str);

           if (map.containsKey(currLetters)) {
                map.get(currLetters).add(str);
           } else {
                List<String> newList = new ArrayList<>();
                newList.add(str);
                map.put(currLetters, newList);
           }
        }

        return new ArrayList<>(map.values());
    }


    private List<Integer> getLettersArray(String str) {
        List<Integer> letters = new ArrayList<>(Collections.nCopies(26,0));

        for (int i = 0; i < str.length(); i++) {
           letters.set(str.charAt(i) - 'a', letters.get(str.charAt(i) - 'a') + 1);
        }

        return letters;
    }
}
