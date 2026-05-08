class Solution {
    public int findKthLargest(int[] nums, int k) {
        Queue<Integer> q = new PriorityQueue(Collections.reverseOrder());
        for (int i : nums) {
            q.offer(i);
        }
        int res = -1;
        while(k > 0) {
            res = q.poll();
            k--;
        }
        return res;
    }
}
