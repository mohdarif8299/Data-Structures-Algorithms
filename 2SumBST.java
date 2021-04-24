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
    public int t2Sum(TreeNode A, int B) {
        ArrayList<Integer> al = inOrder(A,new ArrayList<>());
        int p1=0,p2=al.size()-1;
        while(p1<p2) {
            if(al.get(p1)+al.get(p2)==B) return 1;
            if(al.get(p1)+al.get(p2)<B) {
                p1++;
            }
            else {
                p2--;
            }
        }
        return 0;
    }
    public static ArrayList<Integer> inOrder(TreeNode A,ArrayList<Integer> al) {
        if(A==null) return null;
        inOrder(A.left,al);
        al.add(A.val);
        inOrder(A.right,al);
        return al;
    }
}
