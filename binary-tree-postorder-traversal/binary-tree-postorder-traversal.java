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
    public List<Integer> postorderTraversal(TreeNode root) {
      return postorder(root, new ArrayList<>());   
    }
    public static List<Integer> postorder(TreeNode root, List<Integer> list) {
        if(root == null) return list;
        postorder(root.left, list);
        postorder(root.right, list);
        list.add(root.val);
        return list;
    }
}