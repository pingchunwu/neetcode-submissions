class Solution {
    public int[][] insert(int[][] intervals, int[] newInterval) {
        Queue<int[]> q = new PriorityQueue<>(Comparator.comparing(interval->interval[0]));
        q.offer(newInterval);
        List<int[]> list = new ArrayList();
        for (int[] interval: intervals) {
            q.offer(interval);
        }
        while(q.size()>1) {
            int[] cur = q.poll();
            int[] next = q.poll();
            // System.out.println("cur " + cur[0] + " " + cur[1]);
            // System.out.println("next " + next[0] + " " + next[1]);
            if (next[0] <= cur[1]){
                int[] newInt = new int[]{cur[0], Math.max(cur[1], next[1])};
                q.offer(newInt);
            } else {
                list.add(cur);
                q.offer(next);
            }
        }
        if (q.size() > 0) {
            list.add(q.poll());
        }
        return list.toArray(new int[list.size()][]);
    }
}
