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
    // DO NOT MODIFY THE ARGUMENTS WITH "final" PREFIX. IT IS READ ONLY
    public TreeNode sortedArrayToBST(final int[] A) {
        return makeBSTBalanced(A,0,A.length-1);
    }
    public static TreeNode makeBSTBalanced(int A[],int l,int r) {
        if(l>r) return null;
        int mid = (l+r)/2;
        TreeNode node = new TreeNode(A[mid]);
        node.left = makeBSTBalanced(A,l,mid-1);
        node.right = makeBSTBalanced(A,mid+1,r);
        return node;
    }
}
