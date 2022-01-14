/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    public int widthOfBinaryTree(TreeNode root) {
        Queue<Pair> queue = new LinkedList<>();
        queue.add(new Pair(root,0));
        long ans = Integer.MIN_VALUE;
        while(!queue.isEmpty()) {
            int size = queue.size();
            int min = Integer.MAX_VALUE;
            int max = Integer.MIN_VALUE;
            while(size > 0) {
                Pair p = queue.poll();
                max = Math.max(max, p.index);
                min = Math.min(min, p.index);
                if( p.node.left!=null)
                    queue.add(new Pair(p.node.left, p.index*2+1));
                if( p.node.right!=null )
                    queue.add(new Pair(p.node.right, p.index*2+2));
                size--;
            }
            ans = Math.max(ans, Math.abs(max-min) + 1);
        }
        return (int)ans;
    }
    public class Pair {
        TreeNode node;
        int index;
        Pair(TreeNode node, int index) {
            this.node = node;
            this.index = index;
        }
    }
}