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
    public int solve(TreeNode A, int B) {
        count=0;
        eachNodeKLevel(A,B);
        return count;
    }
    public static void eachNodeKLevel(TreeNode root,int K) {
        if(root==null) return;
        kDown(root,K,root);
        eachNodeKLevel(root.left,K);
        eachNodeKLevel(root.right,K);
    }
    private static void kDown(TreeNode root,int K,TreeNode target) {
        
        if(root==null || K<0)  return;
        if(K==0 && root.val!=target.val) count++;
        kDown(root.left,K-1,target);
        kDown(root.right,K-1,target);
        
    }
}
