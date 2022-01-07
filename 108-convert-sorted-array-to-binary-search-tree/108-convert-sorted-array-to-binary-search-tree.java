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
    public TreeNode sortedArrayToBST(int[] nums) {
        return bst(0, nums.length - 1, nums);
    }
    public static TreeNode bst(int start, int end, int nums[]) {
        if(start > end) return null;
        int mid = (start + end)/2;
        TreeNode node = new TreeNode(nums[mid]);
        node.left = bst(start, mid - 1, nums);
        node.right = bst(mid + 1, end, nums);
        return node;
    }
}