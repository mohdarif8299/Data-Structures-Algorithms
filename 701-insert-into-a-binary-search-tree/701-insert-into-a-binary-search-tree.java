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
    TreeNode prevNode = null;
    public TreeNode insertIntoBST(TreeNode root, int val) {
        if(root == null) {
            return new TreeNode(val);
        }
        return insertNode(root, val, 0);
    }
    public TreeNode insertNode(TreeNode root, int val, int pos) {
        if(root == null) {
            TreeNode node = new TreeNode(val);
            if(pos == -1)
                prevNode.left = node;
            else 
                prevNode.right = node;
            return root;
        }
        prevNode = root;
        if(val < root.val) {
            insertNode(root.left, val, -1);
        } else {
            insertNode(root.right, val, 1);
        }
        return root;
    }
}