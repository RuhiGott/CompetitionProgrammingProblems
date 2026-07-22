class Solution {
    public int maxProfit(int[] prices) {
        if (prices.length == 1) {
            return 0;
        }

        int left = 0;
        int right = 1;

        int maxProfit = Math.max(0, prices[1] - prices[0]);

        while (right + 1 < prices.length) {
            if (prices[right] < prices[left]) { 
                left = right;
            }

            right++;

            maxProfit = Math.max(maxProfit, prices[right] - prices[left]);
        }

        return maxProfit;
    }
}
