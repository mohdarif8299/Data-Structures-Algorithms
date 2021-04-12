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
    public ArrayList<Integer> postorderTraversal(TreeNode A) {
        Stack<TreeNode> stack = new Stack<>();
        Stack<Integer> value = new Stack<>();
        if(A!=null) stack.push(A);
        while(!stack.isEmpty()) {
            TreeNode treeNode = stack.pop();
            value.push(treeNode.val);
            if(treeNode.left!=null) stack.push(treeNode.left);
            if(treeNode.right!=null) stack.push(treeNode.right);
        }
        ArrayList<Integer> ans = new ArrayList<>();
        while(!value.isEmpty()) {
            ans.add(value.pop());
        }
        return ans;
    }
}
