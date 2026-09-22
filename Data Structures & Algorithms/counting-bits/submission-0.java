class Solution {
    public int[] countBits(int n) {
        int[] res = new int[n+1];
        for (int i = 0 ; i < n+1; i++) {
            int cur = i;
            while (cur != 0) {
                cur &= cur - 1;
                res[i] ++;
            }
            
        }
        return res;
    }
}
