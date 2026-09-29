class Solution {
    Set<List<Integer>> res = new HashSet<>();
    public List<List<Integer>> combinationSum(int[] nums, int target) {
        List<Integer> cur = new ArrayList<>();
        dfs(nums, target, cur, 0);
        List<List<Integer>> f = new ArrayList<>(res);
        return f;
    }

    private void dfs(int[] nums, int target, List<Integer> cur, int i) {
        if (target == 0) {
            res.add(new ArrayList<>(cur));
            return;
        }
        
        if (target < 0 || i == nums.length) {
            return;
        }

        cur.add(nums[i]);
        dfs(nums, target - nums[i], cur, i);
        cur.remove(cur.size()-1);
        dfs(nums, target, cur, i + 1);

    }
}





























// class Solution {
//     List<List<Integer>> res = new ArrayList();
//     public List<List<Integer>> combinationSum(int[] nums, int target) {
//         List<Integer> sub = new ArrayList();

//         dfs(nums, target, 0, sub);
//         return res;
//     }

//     private void dfs(int[] nums, int target, int i, List<Integer> sub) {
//         if (0 == target) {
//             res.add(new ArrayList(sub));
//             return;
//         }
//         if (0 > target || nums.length == i) {
//             return;
//         }

//         sub.add(nums[i]);
//         dfs(nums, target - nums[i], i, sub);
//         sub.remove(sub.size() - 1);
//         dfs(nums, target, i+1, sub);
//     }
// }
