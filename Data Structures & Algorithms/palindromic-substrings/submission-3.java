class Solution {
    public int countSubstrings(String s) {
        int n = s.length();
        int res = 0;
        for (int i = 0 ; i < n; i++) {
            // odd
            int l = i - 1;
            int r = i + 1;
            while (l >= 0 && r >= 0 && l < n && r < n &&
                    s.charAt(l) == s.charAt(r)) {
                        res++;
                        l--;
                        r++;
                    }

            // even
            l = i;
            r = i + 1;
            while (l >= 0 && r >= 0 && l < n && r < n &&
                    s.charAt(l) == s.charAt(r)) {
                        res++;
                        l--;
                        r++;
                    }
            res++;
        }

        return res;
    }
}
