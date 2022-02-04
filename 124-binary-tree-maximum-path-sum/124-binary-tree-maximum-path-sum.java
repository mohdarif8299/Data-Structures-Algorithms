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
    int ans = Integer.MIN_VALUE;
    public int maxPathSum(TreeNode root) {
        ans = Integer.MIN_VALUE;
        maxSum(root);
        return ans;
    }
    public int maxSum(TreeNode A) {
      if(A==null) return 0;
        int left = Math.max(maxSum(A.left),0);
        int right = Math.max(maxSum(A.right),0);
        ans= Math.max(ans,A.val+left+right);
        return A.val+Math.max(0,Math.max(left,right));
    }
}