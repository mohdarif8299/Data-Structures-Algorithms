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
    public int kthsmallest(TreeNode A, int B) {
        ArrayList<Integer> al = inOrder(A,new ArrayList<>());
        return al.get(B-1);
    }
    public static ArrayList<Integer> inOrder(TreeNode A,ArrayList<Integer> al) {
        if(A==null) return al;
        inOrder(A.left,al);
        al.add(A.val);
        inOrder(A.right,al);
        return al;
    }
}
