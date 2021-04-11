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
    public boolean leafSimilar(TreeNode root1, TreeNode root2) {
       
        List<Integer> leaf1 = getLeafNodes(root1);
        List<Integer> leaf2 = getLeafNodes(root2);
        return leaf1.equals(leaf2);
    }
    public static List<Integer> getLeafNodes(TreeNode root1) {
         Stack<TreeNode> stack = new Stack<>();
        List<Integer> leaf1 = new ArrayList<>();
        while(root1!=null || !stack.isEmpty()) {
            if(root1!=null) {
                stack.push(root1);
                root1 = root1.left;
            } else {
                root1 = stack.pop();
                if( root1.left==null && root1.right==null)
                leaf1.add(root1.val);
                root1 = root1.right;
            }
        }
        return leaf1;
    }
}
