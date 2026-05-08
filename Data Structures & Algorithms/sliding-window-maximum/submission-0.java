class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        int[] res = new int[nums.length - k + 1];
        for (int l = 0 ; l < nums.length - k + 1; l ++) {
            int r = l + k - 1;
            int max = nums[l];
            System.out.println("--------- ");
            System.out.println("l "+l);
            System.out.println("r "+r);
            for (int i = l ; i <= r; i++) {
                System.out.println("i "+i);
                max = Math.max(max, nums[i]);
            }
            res[l] = max;
        }
        return res;
    }
}
