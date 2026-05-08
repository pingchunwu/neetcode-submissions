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
    List<Integer> list = new ArrayList();
    public int kthSmallest(TreeNode root, int k) {
        if (root == null) {
            return 0;
        }

        deep(root);
        list.sort(Comparator.comparing(n -> n));
        return list.get(k - 1);
    }

    private void deep(TreeNode n) {
        if (n == null) {
            return;
        }
        list.add(n.val);

        deep(n.left);
        deep(n.right);
    }
}
