class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> res = new ArrayList();

        for (int i = 0 ; i < nums.length; i ++) {
            if (nums[i] > 0) break;
            if (i != 0 && nums[i] == nums[i-1]) {
                continue;
            }
            int target = -nums[i];
            int l = i + 1;
            int r = nums.length -1;
            while (r > l) {
                int sum = nums[r] + nums[l];
                // break;
                if (sum > target) {
                    r --;
                } else if (sum < target) {
                    l ++;
                } else {
                    res.add(List.of(nums[i], nums[l], nums[r]));
                    r--;
                    l++;
                    while (l < r && nums[l] == nums[l-1]) {
                        l++;
                    }
                }

            }
        }
        return res;
    }
}
