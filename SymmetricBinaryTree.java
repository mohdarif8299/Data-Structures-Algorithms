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
    public int isSymmetric(TreeNode A) {
        return checkSymmetric(A.left,A.right);
    }
    public static int checkSymmetric(TreeNode left,TreeNode right) {
        if(left==null && right==null) return 1;
        if(left==null || right==null) return 0;
        int bool = (left.val==right.val)?1:0;
        checkSymmetric(left.left,left.right);
        checkSymmetric(right.left,right.left);
        return bool;
    }
}
