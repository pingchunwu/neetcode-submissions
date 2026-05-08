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
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> res = new ArrayList();
        Queue<TreeNode> q = new LinkedList();

        q.add(root);
        while (!q.isEmpty()) {
            
            Stack<TreeNode> s = new Stack();

            for (int i = q.size() ; i > 0; i--) {
                TreeNode n = q.poll();
                if (n != null) {
                    s.push(n);
                    q.add(n.left);
                    q.add(n.right);
                }
            }
            
            if (!s.isEmpty()) {
                res.add(s.pop().val);
            }
            
        }
        return res;
        
    }
}
