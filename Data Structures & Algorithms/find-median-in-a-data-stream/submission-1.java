class MedianFinder {

    Queue<Integer> q = new PriorityQueue<>();

    public MedianFinder() {
        
    }
    
    public void addNum(int num) {
        q.offer(num);
    }
    
    public double findMedian() {
        Queue<Integer> tem = new PriorityQueue<>(q);
        int mIndex = q.size() / 2;
        if (q.size() % 2 == 0) {
            int mIndex2 = mIndex - 1;
            while(mIndex2 != 0) {
                tem.poll();
                mIndex2--;
            }
            double first = tem.poll();
            double second = tem.poll();
            return (first+second)/2;
        } else {
            while(mIndex != 0) {
                tem.poll();
                mIndex--;
            }
            return tem.poll();
        }
    }
}
