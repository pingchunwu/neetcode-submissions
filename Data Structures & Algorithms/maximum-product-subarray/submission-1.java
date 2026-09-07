class Solution {
    public int maxProduct(int[] nums) {
        int max = nums[0];
        int min = nums[0];
        int res = nums[0];
        for (int i = 1 ; i < nums.length; i ++) {
            int cur = nums[i];
            int maxCur = cur*max;
            int minCur = cur*min;

            max = Math.max(cur, Math.max(maxCur, minCur));
            min = Math.min(cur, Math.min(maxCur, minCur));

            res = Math.max(max, res);
        }
        return res;
    }
}
