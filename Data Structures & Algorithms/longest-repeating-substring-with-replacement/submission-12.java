class Solution {
    public int characterReplacement(String s, int k) {
        Set<Character> set = new HashSet<>();
        for (int i = 0; i < s.length(); i ++) {
            set.add(s.charAt(i));
        }

        int max = 0;
        for (char c: set) {
            int leftK = k;
            int l = 0;
            for (int r = 0; r < s.length(); r ++) {
                if (s.charAt(r) == c) {
                } else {
                    while (leftK == 0) {
                        if (s.charAt(l) != c) {
                            leftK++;
                        }
                        l++;
                    }
                    leftK --;
                }
                max = Math.max(max, r-l+1);
            }
        }
        return max;
    }
}
