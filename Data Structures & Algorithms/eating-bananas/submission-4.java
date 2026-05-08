class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        if (piles.length == 1) {
            int init = piles[0] / h;
            if (piles[0] % h != 0) {
                init ++;
            }
            return init;
        }
        Arrays.sort(piles);
        int l = 1;
        int r = piles[piles.length - 1];
        int res = r;
        while(r>=l) {
            System.out.println("l " + l +" r " +r);
            int k = (l + r)/2;
            int count = 0;
            for (int pile: piles) {
                if (k == 0) {
                    continue;
                }
                count += pile/k;
                if (pile % k != 0) {
                    count ++;
                }
            }
            System.out.println("count " + count + ", k " + k);

            if (count <= h) {
                res = Math.min(res, k);
                r = k-1;
            } else {
                l = k + 1;
            }
        }
        return res;
    }
}
