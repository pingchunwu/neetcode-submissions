class Solution {
    public boolean isValid(String s) {
        Stack<Character> stack = new Stack();
        for (int i = 0 ; i < s.length(); i ++) {
            Character c = s.charAt(i);
            if (c == '(' || 
                c == '[' || 
                c == '{') {
                stack.push(c);
            } else {
                if (stack.size() > 0) {
                    Character found = stack.peek();
                    if (found == '(' && c == ')' || 
                        found == '[' && c == ']' || 
                        found == '{' && c == '}') {
                        stack.pop();
                    } else {
                        return false;
                    }
                } else {
                    return false;
                }
            }
        }

        return stack.size() == 0;
    }
}
