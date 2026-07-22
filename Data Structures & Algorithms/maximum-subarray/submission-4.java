class Solution {
    public int maxSubArray(int[] nums) {
        int max = nums[0];
        int l = 0;
        int r = 0;
        while(l <= r && r < nums.length) {
            int num = 0;
            for (int i = l; i <= r; i++) {
                num += nums[i];
            }
            max = Math.max(num, max);
            if (r == nums.length - 1) {
                l++;
                r = l;
            }
            if (r < nums.length - 1) {
                r++;
            }
        }
        return max;
    }
}
