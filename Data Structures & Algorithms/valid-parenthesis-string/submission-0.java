class Solution {
    public boolean checkValidString(String s) {
        int count = 0;
        Stack<Character> stack = new Stack();
        for (int i = 0 ; i < s.length(); i++) {
            if (s.charAt(i) == '(' || s.charAt(i) == '*') {
                stack.push(s.charAt(i));
            } else if (s.charAt(i) == ')') {
                System.out.println("it's a ) and stack size is " + stack.size());
                if (stack.size() == 0) {
                    return false;
                }
                boolean hasLeft = false;
                for (int j = stack.size() - 1 ; j >= 0; j--) {
                    System.out.println("j " + stack.get(j));
                    if (stack.get(j) == '(') {
                        stack.remove(j);
                        hasLeft = true;
                        break;
                    }
                }
                if (hasLeft) {
                    continue;
                }
                char c1 = stack.pop();
                System.out.println("gonna pop a " + c1);
                // stack.pop();
            }
        }
        int right = 0;
        while(stack.size() > 0) {
            System.out.println("stack.size() " + stack.size());
            char c = stack.pop();
            System.out.println("last " + c);
            if (c == '*') {
                right++;
            } else if (c == '(') {
                if (right > 0) {
                    right--;
                } else {
                    return false;
                }
            }
        }
        return true;
    }
}
