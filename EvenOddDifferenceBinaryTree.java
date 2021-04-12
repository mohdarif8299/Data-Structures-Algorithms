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
    public static class Pair {
        TreeNode treeNode;
        int level;
        Pair(TreeNode treeNode,int level) {
            this.treeNode = treeNode;
            this.level = level;
        }
    }
    public int solve(TreeNode A) {
        int evenSum=0,oddSum=0;
        Queue<Pair> queue = new LinkedList<>();
        queue.add(new Pair(A,1));
        while(!queue.isEmpty()) {
            int level = queue.peek().level;
            while(!queue.isEmpty() && level==queue.peek().level) {
                Pair p  = queue.poll();
                if(p.level%2==1) {
                    oddSum+=p.treeNode.val;
                }
                else {
                    evenSum+=p.treeNode.val;
                }
                if(p.treeNode.left!=null) queue.add(new Pair(p.treeNode.left,p.level+1));
                if(p.treeNode.right!=null) queue.add(new Pair(p.treeNode.right,p.level+1));
            }
        }
        return oddSum-evenSum;
    }
}
