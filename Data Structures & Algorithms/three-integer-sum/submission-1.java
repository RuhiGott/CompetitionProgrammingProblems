class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> solution = new ArrayList<>();
        Arrays.sort(nums);

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] > 0) {
                break;
            }
            if (i > 0 && nums[i] == nums[i-1]) {
                continue;
            }
            int j = i+1;
            int k = nums.length - 1;

            while (j < k) {
                int currSum = nums[j] + nums[k];
                int target = -1 * nums[i];

                if (currSum == target) {
                    solution.add(Arrays.asList(nums[i], nums[j], nums[k]));
                    j++;
                    k--;
                    while (j < k && nums[j] == nums[j-1]) j++;
                    while (j < k && nums[k] == nums[k+1]) k--;
                } else if (currSum < target) {
                    j++;
                } else {
                    k--;
                }
            }
        }

        return solution;
    }
}
