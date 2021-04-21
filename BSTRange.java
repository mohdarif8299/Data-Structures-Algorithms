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
    int count=0;
    public int solve(TreeNode A, int B, int C) {
        if(A==null) return count;
         if(A.val>=B && A.val<=C) count+=1;
          solve(A.left,B,C);
          solve(A.right,B,C);
        return count;
    }
}
