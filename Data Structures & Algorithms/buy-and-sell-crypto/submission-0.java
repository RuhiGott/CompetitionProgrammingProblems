class Solution {
    public int maxProfit(int[] prices) {
        int maxProfit = 0;
        int left = 0;

        for (int right = 1; right < prices.length; right++) {
            maxProfit = Math.max(maxProfit, prices[right] - prices[left]);
            
            if (prices[right] < prices[left]) {
                left = right;
            }
        }

        return maxProfit;
        
    }
}
