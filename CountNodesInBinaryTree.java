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
        int leftCount = solve(A.left);
        int rightCount = solve(A.right);
        return leftCount+rightCount+1;
    }
}
