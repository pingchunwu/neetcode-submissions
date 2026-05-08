class Solution {
    List<List<Integer>> res = new ArrayList();
    public List<List<Integer>> combinationSum(int[] nums, int target) {
        List<Integer> sub = new ArrayList();

        dfs(nums, target, 0, sub);
        return res;
    }

    private void dfs(int[] nums, int target, int i, List<Integer> sub) {
        // target-= nums[i];
        // int sum = 0;
        // for (int num: sub) {
        //     // System.out.print(num);
        //     sum+=num;
        // }
        if (0 == target) {
            res.add(new ArrayList(sub));
            return;
        }
        if (0 > target || nums.length == i) {
            return;
        }
        // System.out.println(" sum " + sum);

        sub.add(nums[i]);
        dfs(nums, target - nums[i], i, sub);
        sub.remove(sub.size() - 1);
        dfs(nums, target, i+1, sub);
        
    }
}
