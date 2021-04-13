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
    public ArrayList<ArrayList<Integer>> zigzagLevelOrder(TreeNode A) {
        Queue<Pair> queue = new LinkedList<>();
        ArrayList<ArrayList<Integer>> ans = new ArrayList<>();
        queue.add(new Pair(A,0));
        while(!queue.isEmpty()) {
            ArrayList<Integer> zigZag = new ArrayList<>();
            Stack<Integer> stack = new Stack<>();
            int level = queue.peek().level;
            while(!queue.isEmpty() && level==queue.peek().level) {
                Pair p = queue.poll();
                if(p.level%2==0) {
                    zigZag.add(p.treeNode.val);
                }
                else {
                    stack.push(p.treeNode.val);
                }
                if(p.treeNode.left!=null) queue.add(new Pair(p.treeNode.left,p.level+1));
                if(p.treeNode.right!=null) queue.add(new Pair(p.treeNode.right,p.level+1));
            }
            while(!stack.isEmpty()) {
                zigZag.add(stack.pop());
            }
            ans.add(zigZag);
        }
        return ans;
    }
}
