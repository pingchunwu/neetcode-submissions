class Solution {
    public boolean isValid(String s) {
        if (s.length() %2 != 0) {
            return false;
        }
        Stack<Character> stack = new Stack();
        for (char c : s.toCharArray()) {
            if (c == '[' || c == '(' || c == '{') {
                stack.add(c);
            } else {
                if (stack.size() <= 0) {
                    return false;
                }
                if ((stack.peek() == '[' && c == ']') ||
                    (stack.peek() == '(' && c == ')') ||
                    (stack.peek() == '{' && c == '}')){
                        stack.pop();
                } else {
                    return false;
                }
            }
        }
        if (stack.size() != 0) {
            return false;
        }
        return true;
    }
}
