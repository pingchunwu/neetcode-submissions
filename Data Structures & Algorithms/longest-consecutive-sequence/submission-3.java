class Solution {
    public int longestConsecutive(int[] nums) {
        if (nums.length <= 1) {
            return nums.length;
        }
        Arrays.sort(nums);
        int max = 0;
        int acc = 1;
        for (int i = 0 ; i < nums.length - 1; i ++) {
            int cur = nums[i];
            int next = nums[i + 1];
            if (next == cur) {
                continue;
            }
            if (next - cur == 1) {
                acc++;
            } else {
                max = Math.max(max, acc);
                acc = 1;
            }
        }
        max = Math.max(max, acc);

        return max;
    }
}
