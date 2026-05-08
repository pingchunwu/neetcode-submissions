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

public class Codec {
    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        String encoded = "";
        if (root == null) {
            return "null,";
        }
        encoded += root.val + ",";
        encoded += serialize(root.left);
        encoded += serialize(root.right);
        return encoded;
    }

    int count = 0;
    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        System.out.println("data " + data);
        if (data.length() == 0 || "null,".equals(data)) {
            return null;
        }
        String[] sArr = data.split(",");
        TreeNode n =  new TreeNode(Integer.valueOf(sArr[count++]));
        while(count != sArr.length) {
            create(n, sArr);
        }
        return n;
    }

    private void create(TreeNode n, String[] sArr) {
        if (n!= null && sArr.length > count) {
            String str = sArr[count++];
            // System.out.println("str " + str instanceof String);
            System.out.println("str1 " + str);
            if (!str.equals("null")) {
                n.left = new TreeNode(Integer.valueOf(str));
                create(n.left, sArr);
            }
            str = sArr[count++];
            System.out.println("str2 " + str);
            if (!str.equals("null")) {
                n.right = new TreeNode(Integer.valueOf(str));
                create(n.right, sArr);
            }
            
        }
    }
}
