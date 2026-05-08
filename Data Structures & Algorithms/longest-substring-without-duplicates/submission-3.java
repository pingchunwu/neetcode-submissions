class Solution {
    public int lengthOfLongestSubstring(String s) {
        if (s.length() < 2) return s.length();
        int max = 0;
        char[] chars = s.toCharArray();
        int l = 0;
        int r = l+1;
        Set set = new HashSet();
        while (r < s.length()) {
            set.add(chars[l]);
            while (!set.contains(chars[r]) && r < s.length()) {
                set.add(chars[r]);
                r ++;
                if (r > chars.length -1) {
                    break;
                }
            }
            
            max = Math.max(max, set.size());
            set = new HashSet();
            l ++;
            r = l +1;
        }
        if (set.size() > 0) {
            max = Math.max(max, set.size());
        }
        return max;
    }
}
