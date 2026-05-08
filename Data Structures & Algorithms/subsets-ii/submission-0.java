class Solution {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        Set<List<Integer>> res = new HashSet();
        List<Integer> sub = new ArrayList();
        Arrays.sort(nums);
        dfs(nums, res, sub, 0);
        return new ArrayList(res);
    }

    private void dfs(int[] nums, Set<List<Integer>> res, List<Integer> sub, int i) {
        if (i == nums.length) {
            res.add(new ArrayList(sub));
            return;
        }

        sub.add(nums[i]);
        dfs(nums, res, sub, i+1);

        sub.remove(sub.size() -1);
        dfs(nums, res, sub, i + 1);
    }
}
