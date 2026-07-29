class Solution {
    public boolean checkValidString(String s) {
        int leftMin = 0;
        int leftMax = 0;
        for (int i = 0 ; i < s.length(); i++) {
            System.out.println("leftMin? " + leftMin + " leftMax? " + leftMax + " s.charAt(i) " + s.charAt(i));
            if (s.charAt(i) == '(') {
                leftMin ++;
                leftMax ++;
            } else if (s.charAt(i) == '*') {
                // if (leftMin != 0) {
                    leftMin --;
                // }
                leftMax ++;
            } else {
                leftMin --;
                leftMax --;
            }
            if (leftMin <= 0) {
                leftMin = 0;
            }
            if (leftMax < 0) {
                System.out.println("eh?");
                return false;
            }
        }
        System.out.println("leftMin? " + leftMin);
        return leftMin > 0 ? false : true;
    }
}

// class Solution {
//     public boolean checkValidString(String s) {
//         int count = 0;
//         Stack<Character> stack = new Stack();
//         for (int i = 0 ; i < s.length(); i++) {
//             if (s.charAt(i) == '(' || s.charAt(i) == '*') {
//                 stack.push(s.charAt(i));
//             } else if (s.charAt(i) == ')') {
//                 if (stack.size() == 0) {
//                     return false;
//                 }
//                 boolean hasLeft = false;
//                 for (int j = stack.size() - 1 ; j >= 0; j--) {
//                     if (stack.get(j) == '(') {
//                         stack.remove(j);
//                         hasLeft = true;
//                         break;
//                     }
//                 }
//                 if (hasLeft) {
//                     continue;
//                 }
//                 stack.pop();
//             }
//         }
//         int right = 0;
//         while(stack.size() > 0) {
//             char c = stack.pop();
//             if (c == '*') {
//                 right++;
//             } else if (c == '(') {
//                 if (right > 0) {
//                     right--;
//                 } else {
//                     return false;
//                 }
//             }
//         }
//         return true;
//     }
// }
