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
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root.val > p.val && root.val > q.val) {
            return lowestCommonAncestor(root.left, p, q);
        } else if (root.val < p.val && root.val < q.val) {
            return lowestCommonAncestor(root.right, p, q);
        } else {
            return root;
        }


        // Stack<TreeNode> sP = new Stack();
        // Stack<TreeNode> sQ = new Stack();
        // if (root != null){
        //     depth(root, sP, p.val);
        //     depth(root, sQ, q.val);
        // }
        // while(sP.size() > 0) {
        //     TreeNode n = sP.pop();
        //     if (sQ.contains(n)) {
        //         return n;
        //     }
        // }
        // //test
        // return root;
    }

    private boolean depth(TreeNode n, Stack<TreeNode> s, int target) {
        s.push(n);
        if (n == null) {
            s.pop();
            return false;
        }
        if (n.val != target) {
            if (!depth(n.left, s, target) && !depth(n.right, s, target)) {
                s.pop();
                return false;
            }
        }

        return true;
    }
}
