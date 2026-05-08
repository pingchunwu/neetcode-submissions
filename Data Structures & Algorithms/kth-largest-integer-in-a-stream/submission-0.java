class KthLargest {
    List<Integer> list = new ArrayList();
    int k;
    public KthLargest(int k, int[] nums) {
        this.k = k;
        for (int i : nums) {
            list.add(i);
        }
    }
    
    public int add(int val) {
        list.add(val);
        list.sort(Comparator.comparing(n->-n));
        for (int i : list) {
            System.out.println(i);
        }
        return list.get(k - 1);
    }
}
