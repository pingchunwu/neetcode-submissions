class Solution {
    public List<String> generateParenthesis(int n) {
        List<String> res = new ArrayList();
        String cur = "";
        dfs(n, res, cur, 0, 0);
        return res;
    }

    private void dfs(int n, List<String> res, String cur, int l, int r) {
        if (cur.length() == n* 2 && l == r) {
            res.add(cur);
            return;
        }
        String tem = cur;
        if (l < n) {
            cur += "(";
            dfs(n, res, cur, l + 1, r);
            cur = tem;
        }

        if (l > r) {
            cur += ")";
            dfs(n, res, cur, l, r + 1);
            cur = tem;
        }
    }
}
