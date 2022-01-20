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
    public TreeNode increasingBST(TreeNode root) {
        Stack<TreeNode> stack = new Stack<>();
        Stack<TreeNode> in_stack = new Stack<>();
        TreeNode curr = root;
        while(curr!=null || stack.size() > 0) {
            while(curr!=null) {
                stack.push(curr);
                curr = curr.right;
            }
            curr = stack.pop();
            in_stack.push(curr);
            curr = curr.left;
        }
        root = in_stack.peek(); 
        while(!in_stack.isEmpty()) {
            TreeNode node = in_stack.pop();
            if(in_stack.isEmpty()) {
                node.right = null;
                node.left = null;
                break;
            }
            node.right = in_stack.peek();
            node.left = null;
        }
        return root;
    }
}