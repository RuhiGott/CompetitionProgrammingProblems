class Solution {
    public int[] productExceptSelf(int[] nums) {

        //  a        b       c      d       e
        //  a       ab      abc    abcd    acbde
        //abcde     bcde    cde     de      e

        int n = nums.length;

        int[] prefix = new int[n];
        prefix[0] = 1;

        for (int i = 1; i < n; i++) {
            prefix[i] = prefix[i - 1] * nums[i - 1];
        }

        int postfix = 1;

        for (int i = n - 1; i >= 0; i--) {
            prefix[i] *= postfix;
            postfix *= nums[i];
        }

        return prefix;
    }

    

}  
