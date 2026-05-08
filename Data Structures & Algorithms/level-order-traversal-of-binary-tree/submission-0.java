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
    List<List<Integer>> res = new ArrayList();
    Queue<TreeNode> q = new LinkedList();
    public List<List<Integer>> levelOrder(TreeNode root) {
        if (root == null) {
            return res;
        }

        q.add(root);
        while(q.size() > 0) {
            TreeNode n = q.poll();
            layer(n, 0);
        }
        return res;
    }

    private void layer(TreeNode n, int layer) {
        if (n != null) {
            if (res.size() < layer + 1) {
                res.add(new ArrayList());
            }
            res.get(layer).add(n.val);

            layer(n.left, 1+layer);
            layer(n.right, 1+layer);
        } 
        
    }

}
