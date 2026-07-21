class Solution {
    public boolean isAnagram(String s, String t) {
       int[] letterCountArray = new int[26];

       if (s.length() != t.length()) {
            return false;
       }

        for (int i = 0; i < s.length(); i++) {
            letterCountArray[s.charAt(i) - 'a']++;
            letterCountArray[t.charAt(i) - 'a']--;
        }

        System.out.println(Arrays.toString(letterCountArray));
        
        for (int i = 0; i < letterCountArray.length; i++) {
            if (letterCountArray[i] != 0) {
                return false;
            }
        }

        return true;
       
    }
}
