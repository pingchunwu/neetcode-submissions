class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        int[] res = new int[nums.length - k + 1];
        PriorityQueue<Integer> pq = new PriorityQueue(Collections.reverseOrder());
        for (int j = 0; j < k ; j ++) {
            pq.offer(nums[j]);
        }
        res[0] = pq.peek();

        for (int i = 1 ; i < nums.length - k + 1; i++) {
                int prev = nums[i-1];
                pq.remove(prev);
                pq.offer(nums[i + k - 1]);
                res[i] = pq.peek();
        }
        return res;
    }
}
