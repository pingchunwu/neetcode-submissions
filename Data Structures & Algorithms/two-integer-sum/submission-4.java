class Solution {
    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap();
        for (int i = 0 ; i< nums.length; i++) {
            map.put(nums[i], i);
        }
        for (int i = 0 ; i< nums.length; i++) {
            int left = target - nums[i];
            if (map.get(left) != null && map.get(left) != i) {
                return new int[] {i, map.get(left)};
            }
        }
        return new int[0];
    }
}
