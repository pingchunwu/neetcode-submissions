class Solution {
    public boolean isPalindrome(String s) {
        char[] chars = s.toCharArray();
        int front = 0;
        int back = chars.length -1;
        while(front < back) {
            char fc = chars[front];
            char bc = chars[back];
            while (!Character.isLetterOrDigit(fc)&& front < back) {
                front ++;
                fc = chars[front];
            }
            while (!Character.isLetterOrDigit(bc)&& front < back) {
                back --;
                bc = chars[back];
            }
            if (Character.toLowerCase(fc) != Character.toLowerCase(bc)) {
                return false;
            }
            front ++;
            back --;
        }

        return true;
    }
}
