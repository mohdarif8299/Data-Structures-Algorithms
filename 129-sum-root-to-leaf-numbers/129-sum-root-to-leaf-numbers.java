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
    int ans = 0;
    public int sumNumbers(TreeNode root) {
       sum(root, root.val);
        return ans;
    }
    public void sum(TreeNode root, int s) {
        
        if(root.left == null && root.right == null) {
            ans += s;
            return;
        }
        if(root.left!=null)
            sum(root.left, s * 10 + root.left.val);
        if(root.right!=null)
            sum(root.right, s * 10 + root.right.val);
        
    }
}