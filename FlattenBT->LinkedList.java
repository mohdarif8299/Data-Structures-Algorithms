/**
 * Definition for binary tree
 * class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Solution {
	public TreeNode flatten(TreeNode a) {
	    TreeNode temp = a;
	    while(temp!=null) {
	        if(temp.left!=null) {
	            TreeNode right = temp.left;
	            while(right.right!=null) right = right.right;
	            right.right = temp.right;
	            temp.right = temp.left;
	            temp.left = null;
	        }
	        temp = temp.right;
	    }
	    return a;
	}
}
