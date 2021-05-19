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
    
    public static class Node {
        int size;
        boolean isBST;
        int max;
        int min;
        Node(int size,boolean isBST,int max,int min) {
            this.size=size;
            this.isBST =isBST;
            this.max = max;
            this.min = min;
        }
    }
    public int solve(TreeNode A) {
        return largestBST(A).size;
    }
    public static Node largestBST(TreeNode A) {
        if(A==null) return new Node(0,true,Integer.MIN_VALUE,Integer.MAX_VALUE);
        else {
            Node left = largestBST(A.left);
            Node right = largestBST(A.right);
            if(left.isBST && right.isBST && A.val>left.max && A.val<right.min) {
                return new Node(left.size+right.size+1,true,
                Math.max(A.val,Math.max(left.max,right.max)),Math.min(A.val,Math.min(left.min,right.min)));
            } 
            return new Node(Math.max(left.size,right.size),false,0,0);
        }
        
    }
}
