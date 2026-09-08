class Solution {
    public int longestConsecutive(int[] nums) {
        Set<Integer> set = new HashSet<>();
        for (int num : nums) {
            set.add(num);
        }

        int maxLength = 0;
        for (int num : set) {
            if (!set.contains(num - 1)) {
                int currNum = num;
                int currLength = 0;
                while (set.contains(currNum)) {
                    currNum++;
                    currLength++;
                }
                maxLength = Math.max(currLength, maxLength);
            } 
        }

        return maxLength;
    }
}
