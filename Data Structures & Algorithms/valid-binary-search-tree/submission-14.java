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
        return dfs(root, -1001, 1001);
    }

    private boolean dfs(TreeNode root, Integer min, Integer max) {
        if (root == null) {
            return true;
        }
        System.out.println("root " + root.val);

        if (root.left != null) {
            System.out.println("left " + root.left.val);
            if (root.left.val >= root.val || (min != null && root.left.val <= min)) {
                System.out.println("left > root");
                return false;
            }
        }
        if (root.right != null) {
            System.out.println("right " + root.right.val);
            if (root.right.val <= root.val || (max != null && root.right.val >= max)) {
                System.out.println("right < root");
                return false;
            }
        }

        return dfs(root.left, min, Math.min(max, root.val)) && dfs(root.right, Math.max(min, root.val), max);
    }
}
