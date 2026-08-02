class Solution {
    public int[][] merge(int[][] intervals) {
        Arrays.sort(intervals, (a,b) -> a[0] - b[0]);
        List<int[]> res = new ArrayList();
        int n = intervals.length;
        int i = 0;

        while(i < n) {
            int cur = i;
            while (i < n - 1 && intervals[cur][1] >= intervals[i+1][0]) {
                intervals[cur][0] = Math.min(intervals[cur][0], intervals[i+1][0]);
                intervals[cur][1] = Math.max(intervals[cur][1], intervals[i+1][1]);
                i++;
            }
            res.add(intervals[cur]);
            i++;
        }

        return res.toArray(new int[res.size()][]);
    }
}
