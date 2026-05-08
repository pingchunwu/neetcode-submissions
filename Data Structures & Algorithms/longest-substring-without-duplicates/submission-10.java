class Solution {
    public int lengthOfLongestSubstring(String s) {
        if (s.length() == 0) {
            return 0;
        }
        if (s.trim().equals("")){
            return 1;
        }
        Map<Character, Integer> map = new HashMap();
        int max = 0;
        int l = 0;
        int r = 0;
        while(r < s.length()) {
            char cur = s.charAt(r);
            if (map.containsKey(cur)){
                max = Math.max(max, map.keySet().size());
                map.remove(s.charAt(l));
                l++;
            } else {
                map.put(cur, r);
                r ++;
            }
        }
                max = Math.max(max, map.keySet().size());
        return max;
    }
}
