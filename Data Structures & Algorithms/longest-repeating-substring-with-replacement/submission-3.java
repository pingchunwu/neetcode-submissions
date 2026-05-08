class Solution {
    public int characterReplacement(String s, int k) {
        Set<Character> set = new HashSet();
        for (char c: s.toCharArray()) {
            set.add(c);
        }
        int max = 0;

        for (char c: set) {
            int left = k;
            int l = 0;
            for (int r= 0 ; r<s.length(); r ++) {
                // System.out.println("");
                if (s.charAt(r) != c) {
                    if (left > 0) {
                        left --;
                    } else {
                        left--;
                        while (left < 0) {
                            if (s.charAt(l) != c) {
                                left ++;
                            }
                            l++;
                        }
                    }
                    
                }
                max = Math.max(max, r-l+1);
            }
        }
        return max;
    }
}
