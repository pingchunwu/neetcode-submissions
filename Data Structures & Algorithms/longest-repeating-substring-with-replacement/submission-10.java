class Solution {
    public int characterReplacement(String s, int k) {
        Set<Character> set = new HashSet<>();
        for (int i = 0; i < s.length(); i ++) {
            set.add(s.charAt(i));
        }

        int max = 0;
        for (char c: set) {
            System.out.println("-- c " + c);
            int leftK = k;
            int l = 0;
            for (int r = 0; r < s.length(); r ++) {
                // System.out.println("s.charAt(r): " + s.charAt(r) + " leftK: " + leftK + " l: " + l + " r: " + r);
                if (s.charAt(r) == c) {
                } else {
                    // if (l >= r) {
                    //     break;
                    // }
                    while (leftK == 0) {
                        // if(r <= l) {
                        //     l++;
                        //     r++;
                        //     break;
                        // }
                        // System.out.println("leftK: " + leftK + " l: " + l + " r: " + r);
                        if (s.charAt(l) != c) {
                            leftK++;
                        }
                        l++;
                    }
                    leftK --;
                }
                max = Math.max(max, r-l+1);
                // System.out.println("max: " + max + " l: " + l + " r: " + r);
            }
        }
        return max;
    }
}
