class Solution {
    public int numDecodings(String s) {
        if (s.charAt(0) == '0') {
            return 0;
        }

        int[] dp = new int[s.length()+1];
        dp[0] = 1;
        dp[1] = 1;

        for (int i = 2 ; i <= s.length() ; i ++) {
            if (s.charAt(i - 1) != '0') {
                dp[i] += dp[i - 1]; 
            }
            if (s.charAt(i-2) - '0' == 1 || 
                (s.charAt(i-2) - '0' == 2 && s.charAt(i-1) - '0' < 7)) {
                    dp[i] += dp[i-2] ;
            }
        }

        return dp[dp.length-1];
    }

}
