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
    public ArrayList<Integer> inorderTraversal(TreeNode A) {
        ArrayList<Integer> ans = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();
        while(A!=null || !stack.isEmpty()) {
           
           if(A!=null) {
               stack.push(A);
               A = A.left;
           } else {
               A = stack.pop();
               ans.add(A.val);
               A = A.right;
           }
        }
        return ans;
    }
}
