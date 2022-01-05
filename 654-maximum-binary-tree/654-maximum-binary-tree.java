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
    public static int max(int a[], int start, int end) {
        int max = a[start];
        for(int i=start;i<=end;i++)
            max = Math.max(max, a[i]);
        return max;
    }
    public TreeNode constructMaximumBinaryTree(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        for(int i=0;i<nums.length;i++) {
                map.put(nums[i], i);
        }
        return constructTree(0, nums.length - 1, nums, map);
    }
    public static TreeNode constructTree(int start, int end, int nums[], Map<Integer, Integer> map) {
        if(start > end) return null;
        int max = max(nums, start, end);
        TreeNode node = new TreeNode(max);
        node.left = constructTree(start, map.get(max)-1, nums, map);
        node.right = constructTree(map.get(max) + 1, end, nums, map);
        return node;
    }
    
}