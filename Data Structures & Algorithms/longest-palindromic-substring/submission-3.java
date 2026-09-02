class Solution {
    public String longestPalindrome(String s) {
        if (s.length() < 2) return s;
        String res = "";
        Stack<Character> stack = new Stack<>();
        for (int i = 0 ; i < s.length(); i++) {
            for (int j = s.length()-1 ; j > i ; j --) {
                if (s.charAt(i) == s.charAt(j)) {
                    if (isPalindromic(s, i, j)){
                        if (res.length() < j - i + 1) {
                            res = s.substring(i, j+1);
                        }
                    }
                }
                if (i == 7 && j == 9){
                    // System.out.println()
                }
            }
        }
        if (res.length() == 0) {
            res = s.substring(0,1);
        }
        return res;
    }

    private boolean isPalindromic(String s, int i, int j) {
        while(j > i) {
            if (s.charAt(i) != s.charAt(j)) {
                return false;
            }
            i++;
            j--;
        }
        return true;
    }
}
