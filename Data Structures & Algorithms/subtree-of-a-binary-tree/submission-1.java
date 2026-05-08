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
    public boolean isSubtree(TreeNode root, TreeNode subRoot) {
        while (root != null) {
            if (root.val != subRoot.val) {
                return isSubtree(root.left, subRoot) || isSubtree(root.right, subRoot);
            } else {
                if (isSame(root, subRoot)){
                    return true;
                } else {
                    return isSubtree(root.left, subRoot) || isSubtree(root.right, subRoot);
                }
            }
        }
        return false;
    }

    private boolean isSame(TreeNode n1, TreeNode n2) {
        if(n1 == null && n2 == null) {
            return true;
        } else if (n1 != null && n2 != null && n1.val == n2.val) {
            return isSame(n1.right, n2.right) && isSame(n1.left, n2.left);
        } else {
            return false;
        }
    }

}
