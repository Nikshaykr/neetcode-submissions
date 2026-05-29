class Solution {
    public int maxProfit(int[] prices) {
        int maxProfit = 0;
        int minPrice = Integer.MAX_VALUE;

        for (int price : prices){
            minPrice = Math.min(price, minPrice);
            int potentialProfit = price - minPrice;
            maxProfit = Math.max(potentialProfit, maxProfit);
        }
        return maxProfit;
    }
}
