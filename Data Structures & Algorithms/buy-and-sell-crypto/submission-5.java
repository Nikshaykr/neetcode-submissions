class Solution {
    public int maxProfit(int[] prices) {
        int maxProfit = 0, minPrice = Integer.MAX_VALUE;

        for (int price : prices){
            minPrice = Math.min(minPrice, price);

            int currProfit = price - minPrice;

            maxProfit = Math.max(maxProfit, currProfit);
        }
        return maxProfit;
    }
}
