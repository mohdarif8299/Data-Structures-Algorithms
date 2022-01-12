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
    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        if(root == null) return new ArrayList<>();
        Stack<List<Integer>> stack = new Stack<>();
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while(!queue.isEmpty()) {
            int level = queue.size();
            List<Integer> list = new ArrayList<>();
            while(level-- > 0) {
                TreeNode node = queue.poll();
                
                if(node!=null) {
                    list.add(node.val);
                
                    if(node.left!=null) 
                        queue.add(node.left);

                    if(node.right!=null)
                        queue.add(node.right);
                }
            }
            stack.push(list);
        }
        List<List<Integer>> ans = new ArrayList<>();
        while(!stack.isEmpty()) {
            ans.add(stack.pop());
        }
        return ans;
    }
}