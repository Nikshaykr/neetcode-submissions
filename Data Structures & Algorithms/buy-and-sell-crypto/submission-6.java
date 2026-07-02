class Solution {
    public int maxProfit(int[] prices) {
        int maxProfit = 0, minBuy = prices[0];

        for (int price : prices){
            maxProfit = Math.max(maxProfit, price - minBuy);
            minBuy = Math.min(minBuy, price);
        }
        return maxProfit;
    }
}
