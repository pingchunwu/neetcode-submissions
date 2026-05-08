class Solution {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> res = new ArrayList();
        List<Integer> sub = new ArrayList();
        boolean[] remain = new boolean[nums.length];
        bfs(nums, res, sub, remain);
        
        return res;
    }

    private void bfs(int[] nums, List<List<Integer>> res, List<Integer> sub, boolean[] remain) {
        if (sub.size() == nums.length) {
            res.add(new ArrayList(sub));
            return;
        }

        for (int i = 0 ; i < nums.length; i++) {
            if (!remain[i]) {
                sub.add(nums[i]);
                remain[i] = true;
                bfs(nums, res, sub, remain);
                sub.remove(sub.size()-1);
                remain[i] = false;
            }
        }
        
    }
}
