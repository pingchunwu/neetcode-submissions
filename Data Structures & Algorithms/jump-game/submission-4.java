class Solution {
    public boolean canJump(int[] nums) {
        int jump = nums[0];
        return jump(nums, 0, jump);
    }

    private boolean jump(int[] nums, int l, int r) {
        if (r >= nums.length - 1) {
            return true;
        }
        for (int i = l+1; i <= r; i ++) {
            int jump = nums[i];
            if (i + jump >= nums.length - 1) {
                return true;
            }
            if (jump == 0) {
                continue;
            }
            if(jump(nums, i, i + jump)) {
                return true;
            }
        }
        return false;
    }
}
