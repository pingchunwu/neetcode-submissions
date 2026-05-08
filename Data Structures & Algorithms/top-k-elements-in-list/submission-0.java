class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap();
        for (int num: nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }
        List<Map.Entry<Integer, Integer>> list = new ArrayList(map.entrySet());
        list.sort(Map.Entry.comparingByValue());
        for (var entry: list) {
            System.out.println(entry.getKey() + " " + entry.getValue());
        }

        int[] res = new int[k];
        int count = 0;
        for (int i = list.size() -1 ; i > list.size() -k-1 ; i --) {
            res[count] = list.get(i).getKey();
            count ++;
        }
        return res;
    }
}
