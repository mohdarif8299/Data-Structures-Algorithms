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
    long min = Long.MAX_VALUE;
    long secondMin = Long.MAX_VALUE;
    public int findSecondMinimumValue(TreeNode root) {
        secondMin(root);
        if(min == secondMin || secondMin == Long.MAX_VALUE) return -1;
        return (int)secondMin;
    }
    public  void secondMin(TreeNode root) {
        if(root == null) return;
        if(root.val < min) {
            secondMin = min;
            min = root.val;
        }
        else if(root.val < secondMin && min!=secondMin && root.val!=min) {
            secondMin = root.val;
        }
        secondMin(root.left);
        secondMin(root.right);
    }
}