class Solution {
    public int leastInterval(char[] tasks, int n) {
        Map<Character, Integer> map = new HashMap();
        Queue<Integer> q = new PriorityQueue<>(Comparator.comparing(p-> -p));
        Queue<Pair<Integer, Integer>> queue = new LinkedList();

        for(char c: tasks) {
            map.put(c, map.getOrDefault(c,0)+1);
        }

        for (Map.Entry<Character, Integer> e : map.entrySet()) {
            q.offer(e.getValue());
        }

        // while(q.size()>0) {
        //     System.out.println(q.poll());
        // }
        int res = 0;
        while(q.size() > 0 || queue.size() > 0) {
            if (q.size() > 0) {
                int times = q.poll();
                System.out.println("q>0 " + times);
                res++;
                times--;
                if (times > 0) {
                    queue.offer(new Pair<Integer, Integer>(times, res + n));
                }
            } else {
                System.out.println("q<0 " + res);
                res ++;
            }
            if (queue.size() > 0 && queue.peek().getValue() == res) {
                Pair<Integer, Integer> p = queue.poll();
                int t = p.getKey();
                q.offer(t);
            }
        }

        return res;
    }
}
