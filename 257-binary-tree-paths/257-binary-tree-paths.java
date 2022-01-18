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
    public List<String> binaryTreePaths(TreeNode root) {
        return path(root, "", new ArrayList<>());
    }
    public List<String> path(TreeNode root, String str, List<String> ans) {
        if(root == null) {
            return ans;
        }
        
        if(root.left == null && root.right == null) {
            str += root.val;
            ans.add(str);
            return ans;
        }
        else 
            str += root.val + "->";
        
        path(root.left, new String(str), ans);
        path(root.right, new String(str), ans);
        return ans;
    }
}