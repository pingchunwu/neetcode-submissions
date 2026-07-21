public class Solution {
    public int calculate(String s) {
        s = s.replace(" ", "");
        Stack<Integer> stack = new Stack();
        // Stack<Integer> paren = new Stack();
        char op = '+';
        int num = 0;

        for (int i = 0 ; i < s.length() ; i ++) {
            char c = s.charAt(i);
            if (Character.isDigit(c)){
                num *= 10;
                num += c - '0';
            }
            if (!Character.isDigit(c) || i == s.length() - 1) {
                if (c == '(') {
                    int start = i;
                    int left = 1;
                    while (i < s.length()) {

                        if (c == ')') {
                            left--;
                        }
                        if (c == '(') {
                            left++;
                        }
                        if (left == 0) {
                            break;
                        }
                        i ++;
                        c = s.charAt(i);
                    }
                    int end = i;
                    num = calculate(s.substring(start + 1, end));
                } else {
                    if (op == '+') {
                        stack.push(num);
                    } else if (op == '-') {
                        stack.push(-num);
                    } else if (op == '*') {
                        stack.push(stack.pop() * num);
                    } else {
                        stack.push(stack.pop() / num);
                    }
                    op = c;
                    num = 0;
                }
            }
        }

        int res = 0;

        while (!stack.isEmpty()) {
            res += stack.pop();
        }

        return res;
    }
}