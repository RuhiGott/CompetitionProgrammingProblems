class Solution {
    public int longestConsecutive(int[] nums) {
        Set<Integer> set = new HashSet<>();
        for (int num : nums) {
            set.add(num);
        }

        int maxLength = 0;
        int currLength = 0;
        for (int num : set) {
            int currNum = num;
            if (!set.contains(num - 1)) {
                while (set.contains(currNum)) {
                    currNum++;
                    currLength++;
                }
                maxLength = Math.max(currLength, maxLength);
                currLength = 0;
            } 
        }

        return maxLength;
    }
}
