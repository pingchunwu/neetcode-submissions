class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        List<Integer> subset = new ArrayList();
        List<List<Integer>> res = new ArrayList();

        dfs(nums, 0, subset, res);

        return res;
    }

    private void dfs(int[] nums, int i, List<Integer> subset, List<List<Integer>> res) {
        if (i >= nums.length) {
            res.add(new ArrayList(subset));
            return;
        }
        subset.add(nums[i]);
        dfs(nums, i + 1, subset, res);

        subset.remove(subset.size()-1);
        dfs(nums, i + 1, subset, res);
    }
    // private void dfs(int[] nums, int i, List<Integer> subset, List<List<Integer>> res) {
    //     if (i >= nums.length) {
    //         res.add(subset);
    //         return;
    //     }
    //     List<Integer> l1 = new ArrayList(subset);
    //     dfs(nums, i + 1, l1, res);

    //     List<Integer> l2 = new ArrayList(subset);
    //     l2.add(nums[i]);
    //     dfs(nums, i + 1, l2, res);
    // }
}
