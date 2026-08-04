class Solution {
    public int[] minInterval(int[][] intervals, int[] queries) {
        int[] res = new int[queries.length];
        for (int i = 0 ; i < queries.length; i ++) {
            int min = 10001;
            int index = -1;
            for (int j = 0 ; j < intervals.length; j++) {
                if (intervals[j][0] <= queries[i] && intervals[j][1] >= queries[i]) {
                    int interval = intervals[j][1] - intervals[j][0] + 1;
                    if (interval < min) {
                        min = interval;
                        index = j;
                    }
                }
            }
            if (index == -1) {
                res[i] = -1;
            } else {
                res[i] = min;
            }
        }
        return res;
    }
}
