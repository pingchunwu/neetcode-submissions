class MinStack {

    List<Integer> list;

    public MinStack() {
        list = new ArrayList<>();
    }
    
    public void push(int val) {
        list.add(0, val);
    }
    
    public void pop() {
        list.remove(0);
    }
    
    public int top() {
        return list.get(0);
    }
    
    public int getMin() {
        if (list.size() == 0) {
            return 0;
        }
        int min = list.get(0);
        for (Integer i : list) {
            min = Math.min(min, i);
        }
        return min;
    }
}
