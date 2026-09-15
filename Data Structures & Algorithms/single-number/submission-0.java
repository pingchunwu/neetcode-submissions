class Solution {
    public int singleNumber(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int num: nums) {
            if (map.containsKey(num)) {
                map.remove(num);
            } else {
                map.put(num, num);
            }
        }

        int res = 0;
        for(Map.Entry<Integer, Integer> e: map.entrySet()) {
            res = e.getKey();
        }

        return res;
    }
}
