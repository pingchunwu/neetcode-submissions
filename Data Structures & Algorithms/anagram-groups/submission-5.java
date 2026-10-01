class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<Map<Character,Integer>,List<String>> map = new HashMap();
        for (String str: strs) {
            Map<Character,Integer> sub = new HashMap();
            for (char c: str.toCharArray()) {
                sub.put(c, sub.getOrDefault(c,0)+1);
            }
            List<String> tem = map.getOrDefault(sub, new ArrayList<String>());
            tem.add(str);
            map.put(sub, tem);
        }
        return new ArrayList(map.values());
    }
}
