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
    int result = 0;
    public int maxAncestorDiff(TreeNode root) {
        helper(root, root.val, root.val);
        return result;
    }
    public  void helper(TreeNode root, int max, int min) {
        if(root == null) return;
        int temp = Math.max(Math.abs(max - root.val), Math.abs(min - root.val) );
        result = Math.max(result, temp);
        max = Math.max(max, root.val);
        min = Math.min(min, root.val);
        helper(root.left, max, min);
        helper(root.right, max, min);
        
    }
}