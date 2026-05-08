class Solution {
    public int eraseOverlapIntervals(int[][] intervals) {
        Queue<int[]> q = new PriorityQueue<>((a, b) -> Integer.compare(a[0], b[0]) + a[1] - b[1]);
        List<int[]> list = new ArrayList();
        for (int[] interval: intervals) {
            q.offer(interval);
        }
        // while(q.size()>0) {
        //     int[] cur = q.poll();
        //      System.out.println("cur " + cur[0] + " " + cur[1]);
        // }
        int count = 0;
        while(q.size()>1) {
            int[] cur = q.poll();
            int[] next = q.poll();
            // System.out.println("cur " + cur[0] + " " + cur[1]);
            // System.out.println("next " + next[0] + " " + next[1]);
            if (next[0] < cur[1]){
                list.add(cur);
                q.offer(cur);
                count++;
            } else {
                list.add(cur);
                q.offer(next);
            }
        }
        return count;
    }
}
