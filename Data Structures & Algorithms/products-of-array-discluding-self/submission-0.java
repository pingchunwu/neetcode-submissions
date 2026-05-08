class Solution {
    public int[] productExceptSelf(int[] nums) {
        int[] res = new int[nums.length];
        for (int i = 0 ; i < nums.length; i ++) {
            int num = 0;
            boolean started = false;
            for (int j = 0 ; j < nums.length; j++) {
                if (i == j) {
                    continue;
                }
                if (num == 0 && !started) {
                    num = 1;
                }
                started = true;
                num *= nums[j];
            }
            res[i] = num;
        }
        return res;
    }
}  
