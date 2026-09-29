class Solution {
    public int calculate(String s) {
        s = s.replace(" ", "");
        Stack<Integer> stack = new Stack<>();
        char[] cArr = s.toCharArray();
        int cur = 0;
        char op = '+';
        for (int i = 0 ; i < s.length(); i ++) {
            System.out.println("cArr[i] " + cArr[i]);
            while (i < s.length() && Character.isDigit(cArr[i])) {
                cur *= 10;
                cur += cArr[i] - '0';
                i++;
            }
            
            switch(op) {
                case '+' :
            System.out.println("+ " + cur);
                    stack.push(cur);
                    break;
                case '-' :
            System.out.println("- " + cur);
                    stack.push(-cur);
                    break;
                case '*':
            System.out.println("* " + cur);
                    stack.push(stack.pop() * cur);
                    break;
                case '/':
            System.out.println("/ " + cur);
                    stack.push(stack.pop() / cur);
                    break;
            }
            if (i < s.length() && !Character.isDigit(cArr[i])) {
                op = cArr[i];
            }
            cur = 0;


        }

        int res = 0;
        while (!stack.isEmpty()) {
            res += stack.pop();
            System.out.println("> " + res);
        }

        return res;
    }
}