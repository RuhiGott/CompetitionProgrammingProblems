class Solution {
    public int maxArea(int[] heights) {
        int l = 0;
        int r = heights.length - 1;

        int max = 0;

        while (l < r) {
            max = Math.max(max, Math.min(heights[l], heights[r]) * (r - l));

            if (heights[l] < heights[r]) {
                int h = heights[l];
                while (l < r && heights[l] <= h) {
                    l++;
                }
            } else {
                int h = heights[r];
                while (l < r && heights[r] <= h) {
                    r--;
                }
            }
        }

        return max;
    }
}
