class Solution {
    int min = Integer.MAX_VALUE;
    Map<Integer, Integer> map = new HashMap<>();
    public int minCostClimbingStairs(int[] cost) {
        for (int i = cost.length - 3; i >= 0; i --){
            int cur = cost[i];
            int pre1 = cost[i+1];
            int pre2 = cost[i+2];
            cost[i] = cur + Math.min(pre1, pre2);
        }
        return Math.min(cost[0], cost[1]);
    }
}
