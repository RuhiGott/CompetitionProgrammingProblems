class Solution {
    public int[] productExceptSelf(int[] nums) {
        int[] result = new int[nums.length];

          //a        b        c      d      e
          //a        ab      abc    abcd  abcde
        //abcde     bcde     cde     de     e
        
        //bcde      acde     acde   abde   abcd
        // 1 a ab abc abcd

        result[0] = 1;
        for (int i = 1; i < nums.length; i++) {
            result[i] = result[i - 1] * nums[i - 1];
        }

        int postfix = 1;
        for (int i = nums.length - 1; i >= 0; i--) {
            result[i] *= postfix;
            postfix *= nums[i];
        }

        return result;
    }
}  
