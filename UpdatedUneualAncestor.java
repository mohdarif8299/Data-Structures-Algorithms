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
    private static int count=0;
    private static int[] al;
    public int solve(TreeNode A, int B) {
        int countNodes = countNodes(A);
        al = new int[countNodes+1];
        Arrays.fill(al,-1);
        count=0;
        eachNodeKLevel(A,B,0);
        return count;
    }
    public static void eachNodeKLevel(TreeNode root,int K,int level) {
        if(root==null) return;
        al[level] = root.val;
        if(level-K>=0 && al[level-K]!=al[level]) count+=1;
        eachNodeKLevel(root.left,K,level+1);
        eachNodeKLevel(root.right,K,level+1);
        al[level]=-1;
    }
    private static int countNodes(TreeNode root) {
        if(root==null)  return 0;
        int left = countNodes(root.left);
        int right = countNodes(root.right);
        return left+right+1;
        
    }
}
