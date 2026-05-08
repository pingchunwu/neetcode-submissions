class Solution {
    public int maxProfit(int[] prices) {
        if (prices.length == 1){
            return 0;
        }
        int max = 0;
        for (int i = 0 ; i < prices.length ; i++) {
            int base = prices[i];
            for (int j = i + 1; j < prices.length; j++) {
                int future = prices[j];
                max = Math.max(future - base, max);
            }
        }
        return max;
    }
}
