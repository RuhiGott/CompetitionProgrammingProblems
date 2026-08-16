class Solution {
    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>(nums.length);

        for (int i = 0; i < nums.length; i++) {
            int num = nums[i];
            if (map.containsKey(num)) {
                int[] solution = new int[]{map.get(num), i};
                return solution;
            }

            map.put(target - num, i);
        }

        return new int[2];
    }
}
