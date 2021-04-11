/**
 * Definition for binary tree
 * class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) {
 *      val = x;
 *      left=null;
 *      right=null;
 *     }
 * }
 */
public class Solution {
    public int solve(TreeNode A) {
        if(A==null) return 0;
        int leftMax = solve(A.left);
        int rightMax = solve(A.right);
        return Math.max(A.val,Math.max(leftMax,rightMax));
    }
}
