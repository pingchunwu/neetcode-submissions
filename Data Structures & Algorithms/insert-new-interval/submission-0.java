class Solution {
    public int[][] insert(int[][] intervals, int[] newInterval) {
        Queue<int[]> q = new PriorityQueue<>(Comparator.comparing(interval->interval[0]));
        q.offer(newInterval);
        // int[][] res = new int[intervals.length + 1][2];
        List<int[]> list = new ArrayList();
        for (int[] interval: intervals) {
            q.offer(interval);
        }
        while(q.size()>1) {
            int[] cur = q.poll();
            int[] next = q.poll();
            System.out.println("cur " + cur[0] + " " + cur[1]);
            System.out.println("next " + next[0] + " " + next[1]);
            if (next[0] <= cur[1]){
                int[] newInt = new int[]{cur[0], Math.max(cur[1], next[1])};
                q.offer(newInt);
            } else {
                list.add(cur);
                // res[count++] = cur;
                q.offer(next);
            }
        }
        if (q.size() > 0) {
            list.add(q.poll());
            // res[count++] = q.poll();
        }
        int count = 0;
        int[][] res = new int[list.size()][2];
        for (int[] interval: list) {
            res[count++] = interval;
        }
        return res;
    }
}
