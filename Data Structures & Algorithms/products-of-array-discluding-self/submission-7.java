class Solution {
    public int[] productExceptSelf(int[] nums) {

        //  a        b       c      d       e
        //abcde     bcde    cde     de      e

        int n = nums.length;

        int[] postfix = new int[n];
        postfix[n - 1] = nums[n - 1];
        for (int i = n - 2; i >= 0; i--) {
            postfix[i] = postfix[i + 1] * nums[i];
        }

        int[] solution = new int[n];
        int prefix = 1;

        for (int i = 0; i < n - 1; i++) {
            solution[i] = prefix * postfix[i + 1];

            prefix *= nums[i];
        }

        solution[n - 1] = prefix;
        return solution;
    }

    

}  
