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
    public int minDepth(TreeNode root) {
        if(root==null) return 0;
        if(root.left==null) {
            return depthLeft(root);
        }
        else if(root.right==null) {
             return depthRight(root);
        }
        else {
             return depth(root);
        }
    }
    public int depthLeft(TreeNode root) {
        if(root==null) return 0;
        int leftTreeDepth = minDepth(root.right);
        return leftTreeDepth+1;
    }
     public int depthRight(TreeNode root) {
        if(root==null) return 0;
        int leftTreeDepth = minDepth(root.left);
        return leftTreeDepth+1;
    }
    public int depth(TreeNode root) {
        if(root==null) return 0;
        int leftTreeDepth = minDepth(root.left);
        int rightTreeDepth = minDepth(root.right);
        return Math.min(leftTreeDepth,rightTreeDepth)+1;
    }
}
