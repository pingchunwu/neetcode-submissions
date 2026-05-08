class Solution {
    public int eraseOverlapIntervals(int[][] intervals) {
        // Arrays.sort(num, (a, b) -> {
        //     if (a[0] != b[0]) {
        //         return Integer.compare(a[0], b[0]);
        //     } else {
        //         return Integer.compare(a[1], b[1]);
        //     }
        // });
        Queue<int[]> q = new PriorityQueue<>((a, b) -> {
            if (a[0] != b[0]) {
                return Integer.compare(a[0], b[0]); // Sort by start time
            } else {
                return Integer.compare(a[1], b[1]); // Sort by end time if starts are equal
            }
        });
        for (int[] interval: intervals) {
            q.offer(interval);
        }
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
        return count;
    }
}
