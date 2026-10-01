class Solution {
    public int[] productExceptSelf(int[] nums) {
        Map<Integer, Integer> map = new HashMap();
        int total = 1;
        for (int num: nums) {
            map.put(num, map.getOrDefault(num,0)+1);
            if (num != 0) {
                total *= num;
            }
        }

        int[] res = new int[nums.length];
        if (map.containsKey(0) && map.get(0) > 1) {
            return res;
        } else if (map.containsKey(0)){
            int i = 0;
            for (int num: nums) {
                if (num == 0) {
                    res[i++] = total;
                } else {
                    res[i++] = 0;
                }
                
            }
        } else {
            int i = 0;
            for (int num: nums) {
                if (num == 0) {
                    res[i++] = 0;
                } else {
                    res[i++] = total/num;
                }
                
            }
        }

        
        return res;
    }
}  
