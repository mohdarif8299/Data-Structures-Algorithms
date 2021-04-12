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
    public int sumOfLeftLeaves(TreeNode root) {
        List<TreeNode> list= levelOrderTraversal(root);
        int sum=0;
        for(int j=0;j<list.size();j++) {
               TreeNode node = list.get(j);
               if(j%2==1 && node!=null && node.left==null && node.right==null) {
                   sum+=node.val;
               }
        }
        return sum;
    }
    
    public static List<TreeNode> levelOrderTraversal(TreeNode treeNode) {
        List<TreeNode> list = new ArrayList<>();
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(treeNode);
        while(!queue.isEmpty()) {
             TreeNode node = queue.poll();
             list.add(node);
             if(node!=null) {
               queue.add(node.left);
               queue.add(node.right);
            }
        }
        return list;
    }
}
