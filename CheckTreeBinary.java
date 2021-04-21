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
    public int isValidBST(TreeNode A) {
       return checkTree(A,Integer.MIN_VALUE,Integer.MAX_VALUE);
    }
    public static int checkTree(TreeNode A,int min,int max) {
        if(A==null) return 1;
        if(A.val<min || A.val>max) return 0;
        int leftTree = checkTree(A.left,min,A.val-1);
        int rightTree = checkTree(A.right,A.val+1,max);
        if(leftTree==1 && rightTree==1) return 1;  
        else return 0;
    }
}
