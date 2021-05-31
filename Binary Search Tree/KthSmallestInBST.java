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
    public int kthSmallest(TreeNode root, int k) {
        return smallest(root,new ArrayList<>()).get(k-1);   
    }
    public static ArrayList<Integer> smallest(TreeNode root,ArrayList<Integer> al) {
       if(root==null) return al;
        smallest(root.left,al);
        al.add(root.val);
        smallest(root.right,al);
        return al;
    }
}
