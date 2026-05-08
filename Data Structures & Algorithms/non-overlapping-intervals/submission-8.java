class Solution {
    public int eraseOverlapIntervals(int[][] intervals) {
        Queue<int[]> q = new PriorityQueue<>((a, b) -> {
            if (a[0] != b[0]) {
                return Integer.compare(a[0], b[0]); // Sort by start time
            } else {
                return Integer.compare(a[1], b[1]); // Sort by end time if starts are equal
            }
        });
        // Queue<int[]> q = new PriorityQueue<>(Comparator.comparing(a->a[1]));
        // List<int[]> list = new ArrayList();
        for (int[] interval: intervals) {
            q.offer(interval);
        }
        // while(q.size()>0) {
        //     int[] cur = q.poll();
        //      System.out.println("cur " + cur[0] + " " + cur[1]);
        // }
        int count = 0;
        int prevEnd = q.poll()[1];
        for (int i = q.size(); i > 0 ; i -- ) {
            int[] cur = q.poll();
            if (cur[0] < prevEnd) {
                count ++;
                prevEnd = Math.min(prevEnd, cur[1]);
            } else {
                prevEnd = cur[1];
            }
        }



        // while(q.size()>1) {
        //     int[] cur = q.poll();
        //     int[] next = q.poll();
        //     if (next[0] < cur[1]){
        //         list.add(cur);
        //         q.offer(cur);
        //         count++;
        //     } else {
        //         list.add(cur);
        //         q.offer(next);
        //     }
        // }
        return count;
    }
}
