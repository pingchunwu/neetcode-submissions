class Solution {
    public int rob(int[] nums) {
        if (nums.length == 0) return 0;
        if (nums.length == 1) return nums[0];

        int[] dp1 = new int[nums.length];
        dp1[0] = nums[0];
        dp1[1] = Math.max(nums[0],nums[1]);

        for (int i = 2; i < nums.length-1; i ++) {
            dp1[i] = Math.max(dp1[i-1], nums[i] + dp1[i-2]);
        }

        int[] dp2 = new int[nums.length];
        dp2[0] = 0;
        dp2[1] = nums[1];

        for (int i = 2; i < nums.length; i ++) {
            dp2[i] = Math.max(dp2[i-1], nums[i] + dp2[i-2]);
        }

        for (int i = 2; i < nums.length; i ++) {
            System.out.println(dp1[i]);
        }
        
        return Math.max(dp1[dp1.length-2], dp2[dp2.length-1]);
    }
}
