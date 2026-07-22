class Solution {
    public int maxProfit(int[] prices) {
        int left = 0;
        int right = 1;

        int totalProfit = 0;
        int currProfit = 0;

        while (right < prices.length) {
            if (prices[right] < prices[left]) {
                left = right;
                totalProfit += currProfit;
                currProfit = 0;
            }
            
            if (prices[right] - prices[left] > 0) {
                totalProfit += prices[right] - prices[left];
                left = right;
            }
            
            right++;
        }

        return totalProfit;
    }
}