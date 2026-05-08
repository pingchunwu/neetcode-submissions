class Solution {
    public int lastStoneWeight(int[] stones) {
        Queue<Integer> q = new PriorityQueue(Collections.reverseOrder());
        for(int i : stones) {
            q.offer(i);
        }
        
        while(q.size()>1) {
            int first = q.poll();
            int second = q.poll();
            int minus = Math.abs(first-second);
            if (minus != 0) {
                q.offer(minus);
            }
        }
        if (q.size() != 0) {
            return q.peek();
        }
        return 0;
    }
}
