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
    public int hasPathSum(TreeNode A, int B) {
       if(A==null) return 0;
       B-=A.val;
       if(A.left==null && A.right==null) return (B==0)?1:0;
       int bool = hasPathSum(A.left,B);
       int bool2 = hasPathSum(A.right,B);
       return  ((bool|bool2)>0)?1:0;
    }
}
