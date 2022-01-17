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

    int sum = 0;
    public int sumOfLeftLeaves(TreeNode root) {
        sum(root, 0);
        return sum;
    }
    public void sum(TreeNode node, int child) {
        if(node == null) return;
        if(node.left == null && node.right == null && child == -1) sum += node.val;
        sum(node.left, -1);
        sum(node.right, 1);
    }
}