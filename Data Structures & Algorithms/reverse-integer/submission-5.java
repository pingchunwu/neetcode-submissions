class Solution {
    public int reverse(int x) {
        int cur = x;
        int res = 0;
        int tens = 0;
        System.out.println("? Math.abs(cur) " + Math.abs(cur));
        try {
            while (Math.absExact(cur) / 10 > 0) {
                int left = cur % 10;
                cur /= 10;
                res *= 10;
                res += left;
                System.out.println("? tens " + tens + " res " + res);
                if (++tens == 9) {
                    System.out.println("?" + res);
                    return rest(cur, res, x);
                }
            }
        } catch (Exception e) {
            return 0;
        }
        
        res *= 10;
        res += cur;

        return res;
    }

    private int rest(int cur, int res, int x) {
        if (res > 0) {
            if(res > Integer.MAX_VALUE / 10) {
                return 0;
            } else if (cur > 10) {
                return 0;
            } else if (res * 10 + cur < 0) {
                return 0;
            }
            return res * 10 + cur;
        } else {
            if(res < Integer.MIN_VALUE / 10) {
                return 0;
            } else if (Math.abs(cur) > 10) {
                return 0;
            } else if (res * 10 + cur > 0) {
                return 0;
            }
            return res * 10 + cur;
        }
    }
}
