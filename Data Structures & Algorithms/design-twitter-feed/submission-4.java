class Twitter {
    // pair: userId, tweetId
    // Queue<Pair<Integer, Integer>> queue;
    Stack<Pair<Integer, Integer>> s;
    Map<Integer, Set<Integer>> users;

    public Twitter() {
        this.s = new Stack<>();
        // this.queue = new PriorityQueue<>(Comparator.comparing(p -> p));
        // this.queue = new PriorityQueue<>(Comparator.comparing(p -> -p.getValue()));
        this.users = new HashMap();
    }
    
    public void postTweet(int userId, int tweetId) {
        s.push(new Pair<Integer, Integer>(userId, tweetId));
        // queue.offer(new Pair<Integer, Integer>(userId, tweetId));
        // for (Pair<Integer, Integer> p: queue) {
        //     System.out.println("key: " + p.getKey() + " value: " + p.getValue());
        // }
        // System.out.println("- - -");
    }
    
    public List<Integer> getNewsFeed(int userId) {
        List<Integer> res = new ArrayList();
        Set<Integer> user = users.getOrDefault(userId, new HashSet());
        Stack<Pair<Integer, Integer>> tem = new Stack<>();
        tem.addAll(s);
        // Queue<Pair<Integer, Integer>> tem = new PriorityQueue(queue);
        while (tem.size() > 0) {
            // System.out.println("p.getValue() " + p.getValue());
            Pair<Integer, Integer> p = tem.pop();
            if (user.contains(p.getKey()) || userId == p.getKey()){
                res.add(p.getValue());
            }
            if (res.size() == 10) {
                break;
            }
        }
        // res.sort(Comparator.comparing(p -> -p));
        // for (int r : res) {
        //     System.out.println("p.getValue() " + r);
        // }
        return res;
    }
    
    public void follow(int followerId, int followeeId) {
        users.computeIfAbsent(followerId, user -> new HashSet()).add(followeeId);
    }
    
    public void unfollow(int followerId, int followeeId) {
        Set<Integer> user = users.getOrDefault(followerId, new HashSet());
        if (user.contains(followeeId)) {
            user.remove(followeeId);
        }
    }
}
