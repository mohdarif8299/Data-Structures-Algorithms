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
    public int isSameTree(TreeNode A, TreeNode B) {
        System.out.println(getLevelOrderTraversal(A));
        System.out.println(getLevelOrderTraversal(B));
        return getLevelOrderTraversal(A).equals(getLevelOrderTraversal(B))?1:0;
    }
    public static ArrayList<Integer> getLevelOrderTraversal(TreeNode root) {
        ArrayList<Integer> list = new ArrayList<>();
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while(!queue.isEmpty()) {
            TreeNode node = queue.poll();
            if(node==null) list.add(-1); else list.add(node.val);
            if(node!=null) {
                queue.add(node.left); 
                queue.add(node.right); 
            }
        }
        return list;
    }
}
