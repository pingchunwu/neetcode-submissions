class LRUCache {
    int count = 0;
    int capacity;
    Map<Integer, Integer> queue;
    Map<Integer, Integer> map;

    public LRUCache(int capacity) {
        this.queue = new HashMap();
        this.map = new HashMap();
        this.capacity = capacity;
    }
    
    public int get(int key) {
        if (queue.getOrDefault(key, -1) != -1) {
            queue.put(key, ++count);
        }
        return map.getOrDefault(key, -1);
    }
    
    public void put(int key, int value) {
        queue.put( key, ++count);
        map.put(key, value);
        if (queue.size() > capacity) {
            int min = count;
            int minKey= key;
            for (Map.Entry<Integer, Integer> entry: queue.entrySet()) {
                if (entry.getValue() < min) {
                    min = entry.getValue();
                    minKey = entry.getKey();
                }
            }
            queue.remove(minKey);
            map.remove(minKey);
        }
    }
}
