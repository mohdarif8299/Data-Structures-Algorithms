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
      //System.out.println(sum(A));
      if(2*A.val==sum(A)) return 1;
      return 0;
    }
    public static int sum(TreeNode A) {
        if(A==null) return 0;
        int sum = sum(A.left)+sum(A.right);
        return sum+A.val; 
    }
}
