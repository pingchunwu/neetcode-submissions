class Solution {
    public int jump(int[] nums) {
        if (nums.length <= 1) {
            return 0;
        }
        int farthest = 0;
        int cur = 0;
        int jump = 0;
        for (int i = 0 ; i < nums.length; i++) {
            farthest = Math.max(farthest, i + nums[i]);

            if (i == cur) {
                jump ++;
                cur = farthest;
            }

            if (cur >= nums.length - 1) {
                break;
            }
        }
        return jump;
    }
}