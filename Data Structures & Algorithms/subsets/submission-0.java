class Solution {
    int[] numsG;
    List res = new ArrayList();
    public List<List<Integer>> subsets(int[] nums) {
        List<Integer> subset = new ArrayList();
        numsG = nums;

        bfs(0, subset);

        return res;
    }

    private void bfs(int i, List<Integer> subset) {
        if (i >= numsG.length) {
            res.add(subset);
            return;
        }
        List<Integer> l1 = new ArrayList();
        l1.addAll(subset);
        bfs(i+1, l1);

        List<Integer> l2 = new ArrayList();
        l2.addAll(subset);
        l2.add(numsG[i]);
        bfs(i+1, l2);

    }
}
