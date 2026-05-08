class Solution {
    
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> res = new ArrayList();
        List<Integer> sub = new ArrayList();
        Arrays.sort(candidates);
        dfs(candidates, target, sub, 0, res);
        return res;
    }

    private void dfs(int[] candidates, int target, List<Integer> sub, int i, List<List<Integer>> res) {
        if (target == 0) {
            res.add(new ArrayList(sub));
            return;
        }
        if (candidates.length == i || target < 0 || candidates[i] > target) {
            return;
        }

        sub.add(candidates[i]);
        dfs(candidates, target - candidates[i], sub, i + 1, res);
        sub.remove(sub.size()-1);

        int nextIndex = i + 1;
        while(nextIndex < candidates.length && candidates[nextIndex] == candidates[i]) {
            nextIndex++;
        }
        dfs(candidates, target, sub, nextIndex, res);
    }
}
