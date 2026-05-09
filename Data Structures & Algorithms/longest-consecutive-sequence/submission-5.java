class Solution {
    public int longestConsecutive(int[] nums) {
        // find numbers we need for every number we have
        if (nums.length == 0) {
            return 0;
        }

        Set<Integer> numbers = new HashSet<>();

        for (int num : nums) {
            numbers.add(num);
        }

        int length = 1;
        int maxLength = 1;
        for (int num : numbers) {
            if (!numbers.contains(num - 1)) {
                int checkNum = num;
                while(numbers.contains(checkNum + 1)) {
                    length++;
                    checkNum++;
                } 

                maxLength = Math.max(maxLength, length);
                length = 1;
            }
            
        }

        return maxLength;

    }
}
