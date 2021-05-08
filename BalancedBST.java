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
    public int isBalanced(TreeNode A) {
        if(A==null) return 1;
        int left = height(A.left);
        int right = height(A.right);
        if(Math.abs(left-right)<=1 && isBalanced(A.left)==1 && isBalanced(A.right)==1) return 1;
        return 0;
    }
    public static int height(TreeNode A) {
        if(A==null) 
            return 0;
            int left = height(A.left);
            int right = height(A.right);
            return Math.max(left,right)+1;
    }
}
