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
    public int maxDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        
        return Math.max(max(root.left, 1), max(root.right, 1));
    }

    private int max(TreeNode root, int count) {
        if (root != null) {
            count ++;
            return Math.max(max(root.left, count), max(root.right, count));
        }
        return count;
    }
}
