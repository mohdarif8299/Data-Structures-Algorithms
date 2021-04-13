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
    public ArrayList<Integer> solve(TreeNode A) {
        Queue<TreeNode> queue = new LinkedList<>();
        ArrayList<Integer> aList = new ArrayList<>();
        queue.add(A);
        while(!queue.isEmpty()) {
            TreeNode node = queue.poll();
            if(node==null) aList.add(-1); else aList.add(node.val);
            if(node!=null) {
                queue.add(node.left);
                queue.add(node.right);
            }
        }
        return aList;
    }
}
