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
    int max = 0;
    public boolean isBalanced(TreeNode root) {
        if (root == null) {
            return true;
        }
        depth(root, 0);
        return max <= 1;
    }

    private int depth(TreeNode root, int count) {
        if (root == null) {
            return count;
        }
        count ++;

        int left = depth(root.left, count);
        int right = depth(root.right, count);
        max = Math.max(Math.abs(left-right), max);

        return Math.max(left, right);
    }
}
