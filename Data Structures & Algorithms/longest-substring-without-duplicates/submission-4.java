class Solution {
    public int lengthOfLongestSubstring(String s) {
        if (s.length() < 2) return s.length();
        int max = 0;
        Set set = new HashSet();
        int l = 0;

        for (int r = 0; r<s.length(); r++) {
            while(set.contains(s.charAt(r))) {
                set.remove(s.charAt(l));
                l++;
            }
            set.add(s.charAt(r));
            max = Math.max(max, set.size());
        }
        return max;
    }
}
