class Solution {
    public int maxProfit(int[] prices) {
        int max = 0;
        int min = Integer.MAX_VALUE;
        int res = 0;
        for (int p: prices) {
            if (p > max) {
                max = p;
            }
            if (p < min) {
                min = p;
                max = p;
            }
            res = Math.max(max-min, res);
        }
        return res;
    }
}
