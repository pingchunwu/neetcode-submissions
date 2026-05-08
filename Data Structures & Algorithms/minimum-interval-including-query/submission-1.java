class Solution {
    public int[] minInterval(int[][] intervals, int[] queries) {
        int[] res = new int[queries.length];
        for (int j = 0 ; j <queries.length ; j ++) {
            int q = queries[j];
            int min = 10000;
            for (int[] i: intervals) {
                if (i[0] <= q && i[1] >= q) {
                    min = Math.min(min, i[1] - i[0] + 1);
                }else {
                    continue;
                }
            }
            res[j] = min == 10000? -1: min;
        }
        return res;
    }
}
