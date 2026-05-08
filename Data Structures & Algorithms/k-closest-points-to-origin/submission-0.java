class Solution {
    public int[][] kClosest(int[][] points, int k) {
        // pair: distance to index;
        Queue<Pair<Double, Integer>> q = new PriorityQueue<Pair<Double, Integer>>(
            (pair1, pair2) -> pair1.getKey().intValue() - pair2.getKey().intValue());
        for (int i = 0 ; i < points.length; i ++) {
            int x = points[i][0];
            int y = points[i][1];
            double distance = Math.pow(Math.abs(x), 2) + Math.pow(Math.abs(y), 2);
            q.offer(new Pair(distance, i));
        }
        int count = 0;
        int[][] res = new int[k][2];
        while (count != k) {
            Pair<Double, Integer> p = q.poll();
            res[count++] = points[p.getValue()];
        }
        return res;
    }
}
