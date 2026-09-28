/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */

class Solution {
    int res = Integer.MIN_VALUE;
    public int maxPathSum(TreeNode root) {
        int rootVal = root.val;
        int left = dfs(root.left);
        int right = dfs(root.right);
        if (left > 0) {
            rootVal += left;
        }
        if (right > 0) {
            rootVal += right;
        }

        if(rootVal > res) {
            return rootVal;
        }
        return res;
    }

    private int dfs(TreeNode root) {
        int max = 0;
        int cur = 0;
        if (root == null) {
            return 0;
        }

        int left = dfs(root.left);
        int right = dfs(root.right);
        if (left > 0) {
            cur += left;
        }
        if (right > 0) {
            cur += right;
        }
        res = Math.max(cur + root.val, res);
        max = Math.max(Math.max(left, right), max);
        return max + root.val;
    }
}
