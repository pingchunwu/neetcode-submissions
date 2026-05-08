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
    public boolean isValidBST(TreeNode root) {
        if (root == null) {
            return true;
        }

        return check(root.left, -1000, root.val) && check(root.right, root.val, 1000);
    }

    private boolean check(TreeNode n, int left, int right) {
        if (n == null) {
            return true;
        }
        if (n.val > left && n.val < right) {
            int min = Math.min(left, n.val);
            int max = Math.max(right, n.val);
            return check(n.left, min, n.val) && check(n.right, n.val, max);
        } else {
            return false;
        }
    }

}
