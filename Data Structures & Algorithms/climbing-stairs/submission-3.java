class Solution {
    int res;
    public int climbStairs(int n) {
        if (n < 3) return n;
        int one = 1;
        int two = 2;
        for (int i = 2; i < n ; i ++) {
            res = one + two;
            one = two;
            two = res;
        }
        return res;
    }

}
