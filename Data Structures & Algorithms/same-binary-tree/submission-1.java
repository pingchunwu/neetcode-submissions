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
    public boolean isSameTree(TreeNode p, TreeNode q) {
        if (p == null && q == null) {
            return true;
        } else if (p != null && q != null) {
            if (p.val != q.val) {
                return false;
            }
            return isSameTree(p.right, q.right) && isSameTree(p.left, q.left);
        } else {
            return false;
        }
    }




    // public boolean isSameTree(TreeNode p, TreeNode q) {
    //     List<TreeNode> list1 = new ArrayList();
    //     List<TreeNode> list2 = new ArrayList();
    //     iterate(p, list1);
    //     iterate(q, list2);
    //     if (list1.size() != list2.size()) {
    //         return false;
    //     }
    //     for (int i = 0 ; i < list1.size(); i ++) {
    //         TreeNode n1 = list1.get(i);
    //         TreeNode n2 = list2.get(i);
    //         if ((n1 == null && n2 != null) ||
    //             (n1 != null && n2 == null)) {
    //             return false;
    //         } else if (n1 == null && n2 == null) {

    //         } else {
    //             if (n1.val != n2.val) {
    //                 return false;
    //             }
    //         }
    //     }
    //     return true;
    // }

    // private void iterate(TreeNode root, List list) {
    //     if (root == null) {
    //         list.add(root);
    //         return;
    //     }
    //     list.add(root);
    //     iterate(root.left, list);
    //     iterate(root.right, list);
    // }
}
