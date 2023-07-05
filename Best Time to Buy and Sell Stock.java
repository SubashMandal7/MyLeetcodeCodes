class Solution {
    public int maxProfit(int[] prices) {
        int minPrice = Integer.MAX_VALUE; // Initialize the minimum price as the maximum possible value
        int maxProfit = 0; // Initialize the maximum profit as 0

        for (int i = 0; i < prices.length; i++) {
            if (prices[i] < minPrice) {
                minPrice = prices[i]; // Update the minimum price if a lower price is found
            } else if (prices[i] - minPrice > maxProfit) {
                maxProfit = prices[i] - minPrice; // Update the maximum profit if a higher profit is found
            }
        }

        return maxProfit;
    }
}