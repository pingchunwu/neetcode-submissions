class Solution {

    public int eraseOverlapIntervals(int[][] intervals) {
        Arrays.sort(intervals, (a,b) -> a[0] - b[0]);
        int count = 0;
        int end = intervals[0][1];
        for (int i = 0 ; i < intervals.length - 1 ; i ++) {
            int[] cur = intervals[i];
            int[] next = intervals[i+1];
            // System.out.println("i " + i + " end " + end + " next " + next[0] + "," + next[1]);

            if (end > next[0]) {
                // System.out.println("yes overlap");
                if (end <= next[1]) {
                    // System.out.println("end <= next[1]");
                    // do nothing
                } else {
                    // System.out.println("end > next[1], update end to " + next[1]);
                    end = next[1];
                }
                count++;
            } else {
                end = next[1];
            }
        }
        return count;
    }

    
    // public int eraseOverlapIntervals(int[][] intervals) {
    //     Queue<int[]> q = new PriorityQueue<>((a, b) -> {
    //         //  System.out.println("Integer.compare(a[0], b[0]) " + Integer.compare(a[0], b[0]));
    //         //  System.out.println("a[1] " + a[1]);
    //         //  System.out.println("b[1] " + b[1]);
    //         return a[1] - b[1];
    //     });
    //     // List<int[]> list = new ArrayList();
    //     for (int[] interval: intervals) {
    //         q.offer(interval);
    //     }
    //     // while(q.size()>0) {
    //     //     int[] cur = q.poll();
    //     //      System.out.println("cur " + cur[0] + " " + cur[1]);
    //     // }
    //     int count = 0;
    //     while(q.size()>1) {
    //         int[] cur = q.poll();
    //         int[] next = q.poll();
    //         // System.out.println("cur " + cur[0] + " " + cur[1]);
    //         // System.out.println("next " + next[0] + " " + next[1]);
    //         if (next[0] < cur[1]){
    //             // list.add(cur);
    //             q.offer(cur);
    //             count++;
    //         } else {
    //             // list.add(cur);
    //             q.offer(next);
    //         }
    //     }
    //     return count;
    // }
}
