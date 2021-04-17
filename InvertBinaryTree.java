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
    public TreeNode invertTree(TreeNode A) {
        if(A==null) return A;
        TreeNode node = A.left;
        A.left = A.right;
        A.right = node;
        invertTree(A.left);
        invertTree(A.right);
        return A;
    }
}
