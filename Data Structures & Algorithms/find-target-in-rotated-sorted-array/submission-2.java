class Solution {
    public int search(int[] nums, int target) {
        int l = 0;
        int r = nums.length - 1;
        while (r >= l) {
            int m = (r+l)/2;
            int leftN = nums[l];
            int rightN = nums[r];
            int found = nums[m];
            if (found == target) {
                return m;
            }
            if (leftN <= found) {
                if (leftN > target || found < target) {
                    l = m + 1;
                } else {
                    r = m -1;
                }
            } else {
                if (rightN < target || found > target) {
                    r = m - 1;
                } else {
                    l = m + 1;
                }
            }
        }
        return -1;
    }
}
