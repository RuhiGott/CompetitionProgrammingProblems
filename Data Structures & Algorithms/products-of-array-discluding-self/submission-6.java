class Solution {
    public int[] productExceptSelf(int[] nums) {
        int[] prefix = new int[nums.length];
        prefix[0] = nums[0];

        for (int i = 1; i < nums.length; i++) {
            prefix[i] = prefix[i - 1] * nums[i];
        }

        int[] postfix = new int[nums.length];
        postfix[nums.length - 1] = nums[nums.length - 1];
        for (int i = nums.length - 2; i >= 0; i--) {
            postfix[i] = postfix[i + 1] * nums[i];
        }


        int[] solution = new int[nums.length];
        solution[0] = postfix[1];
        solution[nums.length - 1] = prefix[nums.length - 2];

        for (int i = 1; i < nums.length - 1; i++) {
            solution[i] = prefix[i - 1] * postfix[i + 1];
        }

        return solution;
    }



}  
