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
    public TreeNode solve(int[] A) {
        Queue<TreeNode> queue = new LinkedList<>();
        TreeNode node = new TreeNode(A[0]);
        queue.add(node);
        for(int i=1;i<A.length;i++) {
            TreeNode treeNode = queue.poll();
            if(A[i]!=-1) {
                TreeNode left = new TreeNode(A[i]);
                treeNode.left = left;
                queue.add(left);
            }
            if(A[++i]!=-1) {
                 TreeNode right = new TreeNode(A[i]);
                treeNode.right = right;
                queue.add(right);
            }
        }
        return node;
    }
}
