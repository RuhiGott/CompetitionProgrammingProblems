class Solution {
    public int numSubarrayProductLessThanK(int[] nums, int k) {
        if (k == 0) {
            return 0;
        }

        if (nums.length == 1) {
            if (nums[0] < k) {
                return 1;
            } else {
                return 0;
            }
        }

        int count = 0;
        
        int left = 0;
        int right = 0;

        int product = 1;

        while (right < nums.length) {
            product *= nums[right];
            

            while (left <= right && product >= k) {
                product /= nums[left];
                left++;
            }
            count += right - left + 1;
            right++;
        }

        return count;

    }
    
}