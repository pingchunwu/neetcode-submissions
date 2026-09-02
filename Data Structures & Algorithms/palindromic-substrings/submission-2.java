class Solution {
    public int countSubstrings(String s) {
        // List<String> res = new ArrayList<>();
        int n = s.length();
        int res = 0;
        for (int i = 0 ; i < n; i++) {
            // odd
            int l = i - 1;
            int r = i + 1;
            while (l >= 0 && r >= 0 && l < n && r < n &&
                    s.charAt(l) == s.charAt(r)) {
                        // System.out.println("odd l " + l + " r " + r + " string " + s.substring(l, r+1));
                        // res.add(s.substring(l, r+1));
                        res++;
                        l--;
                        r++;
                    }

            // even
            l = i;
            r = i + 1;
            // System.out.println("? l " + l + " r " + r + " string ");
            while (l >= 0 && r >= 0 && l < n && r < n &&
                    s.charAt(l) == s.charAt(r)) {
                        // System.out.println("even l " + l + " r " + r + " string " + s.substring(l, r+1));
                        // res.add(s.substring(l, r+1));
                        res++;
                        l--;
                        r++;
                    }
            // res.add(s.substring(i, i+1));
                        res++;
        }

        // for (String c: res) {
        //     System.out.println("c " + c);
        // }
        // return res.size();
        return res;
    }
}
