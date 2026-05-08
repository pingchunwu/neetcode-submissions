class Solution {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> res = new ArrayList();
        List<Integer> sub = new ArrayList();
        boolean[] pick = new boolean[nums.length];
        bfs(nums, res, sub, pick);
        return res;
    }

    private void bfs(int[] nums, List<List<Integer>> res, List<Integer> sub, boolean[] pick) {
        if (nums.length == sub.size()) {
            res.add(new ArrayList(sub));
            return;
        }

        for (int i = 0 ; i < nums.length; i++) {
            if (pick[i]) {
                continue;
            }
            sub.add(nums[i]);
            pick[i] = true;
            bfs(nums, res, sub, pick);
            sub.remove(sub.size()-1);
            pick[i] = false;
        }
    }
}
