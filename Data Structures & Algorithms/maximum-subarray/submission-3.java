class Solution {
    public int maxSubArray(int[] nums) {
        int max = nums[0];
        int l = 0;
        int r = 0;
        int cur = max;
        while(l <= r && r < nums.length) {
            // System.out.println("round l " + l + " r " + r);
            int num = 0;
            for (int i = l; i <= r; i++) {
                // System.out.println(" nums[i] " + nums[i]);
                num += nums[i];
            }
            // System.out.println("num " + num);
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
