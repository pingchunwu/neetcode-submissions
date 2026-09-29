class Solution {
    public List<String> generateParenthesis(int n) {
        List<String> res = new ArrayList();
        String cur = "";
        bt(0, 0, n, res, cur);
        return res;
    }

    private void bt(int l, int r, int n, List<String> res, String cur) {
        if (l == r && cur.length() == n*2) {
            res.add(new String(cur));
            return;
        }

        if (l < n) {
            bt(l + 1, r, n, res, cur + "(");
        }

        if (l > r) {
            bt(l, r+1, n, res, cur + ")");
        }
    }
}


// class Solution {
//     public List<String> generateParenthesis(int n) {
//         List<String> res = new ArrayList();
//         StringBuilder s = new StringBuilder();
//         dfs(n, res, s, 0, 0);
//         return res;
//     }

//     private void dfs(int n, List<String> res, StringBuilder s, int l, int r) {
//         if (l == r && s.length() == n * 2) {
//             res.add(s.toString());
//             return;
//         }

//         if (l < n) {
//             s.append("(");
//             dfs(n, res, s, l + 1, r);
//             s.deleteCharAt(s.length() - 1);
//         }

//         if (l > r) {
//             s.append(")");
//             dfs(n, res, s, l, r + 1);
//             s.deleteCharAt(s.length() - 1);
//         }
//     }
// }
