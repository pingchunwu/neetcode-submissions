class Solution {
    public int lastStoneWeight(int[] stones) {
        Queue<Integer> q = new PriorityQueue(Collections.reverseOrder());
        for(int i : stones) {
            q.offer(i);
        }

        // while(q.size()>1) {
        //     System.out.println(q.poll());
        // }
        
        while(q.size()>1) {
            int first = q.poll();
            int second = q.poll();
            System.out.println("minus "+ first + " " + second);
            int minus = Math.abs(first-second);
            // System.out.println("minus "+ minus);
            if (minus != 0) {
                q.offer(minus);
            }
        }
        System.out.println("q.size() "+ q.size());
        if (q.size() != 0) {
            return q.peek();
        }
        return 0;
    }
}
