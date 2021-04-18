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
    int res = Integer.MIN_VALUE;
    public int solve(TreeNode A) {
       height(A);
       return res;
    }
    public int height(TreeNode root){
        if(root == null) return 0;
        
        int left = height(root.left);
        int right = height(root.right);
        res = Math.max(res,left+right);
        return 1+Math.max(left,right);
    }
}
