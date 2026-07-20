class Solution {
    public int calculate(String s) {
        s = s.replace(" ", "");
        Stack<Integer> stack = new Stack();
        char[] chars = s.toCharArray();
        int num = 0;
        char op = '+';
        for (int i = 0 ; i < chars.length; i ++) {
            char c = chars[i];
            System.out.println("c " + c);
            if (Character.isDigit(c)) {
                num *= 10;
                num += Character.getNumericValue(c);
            }
            if (!Character.isDigit(c) || i == chars.length - 1){
                if (op == '+') {
                    stack.push(num);
                } else if (op == '-') {
                    stack.push(-num);
                } else if (op == '*') {
                    stack.push(stack.pop() * num);
                } else if (op == '/') {
                    stack.push(stack.pop() / num);
                }
                num = 0;
                op = c;
            }
        }
        int res = 0;
        while(stack.size()>0) {
            res += stack.pop();
        }

        return res;
    }
}