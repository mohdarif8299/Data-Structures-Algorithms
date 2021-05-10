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
    public static Stack<Integer> stack;
    public int solve(TreeNode A) {
        stack = new Stack<>();
        int totalSum = getTreeSum(A);
        stack.pop();
        while(!stack.isEmpty()) {
            int x = stack.peek();
            stack.pop();
            if(x==(totalSum-x)) return 1;
        }
        return 0;
    }
    public static int getTreeSum(TreeNode A) {
        if(A==null) return 0;
        int leftSum = getTreeSum(A.left);
        int rightSum = getTreeSum(A.right);
        stack.push(leftSum+rightSum+A.val);
        return leftSum+rightSum+A.val;
    }
}
