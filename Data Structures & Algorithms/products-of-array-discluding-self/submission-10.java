class Solution {
    public int[] productExceptSelf(int[] nums) {

        //  a        b       c      d       e
        //  a       ab      abc    abcd    acbde
        //abcde     bcde    cde     de      e

        int n = nums.length;

        int[] prefix = new int[n];
        prefix[0] = nums[0];

        for (int i = 1; i < n - 1; i++) {
            prefix[i] = prefix[i - 1] * nums[i];
        }

        int postfix = nums[n - 1];
        
        prefix[n - 1] = prefix[n - 2];

        for (int i = n - 2; i >= 1; i--) {
            prefix[i] = prefix[i - 1] * postfix;
            postfix *= nums[i];
        }

        prefix[0] = postfix;
        return prefix;
    }

    

}  
