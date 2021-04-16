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
    public TreeNode buildTree(int[] A, int[] B) {
        return binaryTree(A,B,0,A.length-1,0,B.length-1);   
    }
    public static TreeNode binaryTree(int A[],int B[],int in_s,int in_e,int pre_s,int pre_e) {
        if(in_s>in_e) return null;
        int root_val = A[pre_s];
        TreeNode node = new TreeNode(root_val);
        int i=in_s;
        for(i=in_s;i<=in_e;i++) {
            if(B[i]==root_val) break;
        }
        node.left = binaryTree(A,B,in_s,i-1,pre_s+1,i-in_s+pre_s);
        node.right = binaryTree(A,B,i+1,in_e,i-in_s+pre_s+1,pre_e);
        return node;
    }
}
