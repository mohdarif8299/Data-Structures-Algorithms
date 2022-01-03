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
    TreeNode prev = null;
    TreeNode n1 = null, n2 = null;
    public void recoverTree(TreeNode root) {
        traverse(root);
        int temp = n1.val;
        n1.val = n2.val;
        n2.val = temp;
    }
    public void traverse(TreeNode root) {
        if(root == null)  return;
        
        traverse(root.left);
        
        if(prev!=null &&  prev.val >= root.val) {
            if(n2==null) {
                n1 = prev;
            }
            n2 = root;
        }
        prev = root;
        traverse(root.right);
    }
}