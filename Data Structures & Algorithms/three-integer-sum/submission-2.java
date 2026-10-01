class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        Map<Integer, Integer> map = new HashMap();
        Set<List<Integer>> res = new HashSet();
        Arrays.sort(nums);

        for (int i = 0 ; i < nums.length; i++) {
            map.put(nums[i], i);
        }
        int total = 0;
        for (int i = 0 ; i < nums.length; i++) {
            int first = nums[i];
            for (int j = i + 1 ; j < nums.length; j ++) {
                int second = nums[j];
                total = first + second;
                if (map.containsKey(-total)) {
                    int index = map.get(-total);
                    if (index <=j) {
                        continue;
                    }
                    int third = nums[index];
                    List<Integer> list = new ArrayList();
                    list.add(first);
                    list.add(second);
                    list.add(third);
                    res.add(list);
                }
            }
        }
        return new ArrayList(res);
    }
}
