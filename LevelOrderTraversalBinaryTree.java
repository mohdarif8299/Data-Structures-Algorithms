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
    public ArrayList<ArrayList<Integer>> levelOrder(TreeNode A) {
        ArrayList<ArrayList<Integer>> ans = new ArrayList<>();
        Queue<Pair> queue = new LinkedList<>();
        queue.add(new Pair(A,0));
        while(!queue.isEmpty()) {
            ArrayList<Integer> al = new ArrayList<>();
            int level = queue.peek().level;
            while(!queue.isEmpty() && level==queue.peek().level) {
                Pair p = queue.poll();
                if(p.treeNode.left!=null) 
                queue.add(new Pair(p.treeNode.left,p.level+1));
                if(p.treeNode.right!=null) 
                queue.add(new Pair(p.treeNode.right,p.level+1));
                al.add(p.treeNode.val);
            }
            ans.add(al);
        }
        return ans;
    }
    static class Pair {
        TreeNode treeNode;
        int level;
        Pair(TreeNode treeNode,int level) {
            this.treeNode = treeNode;
            this.level = level;
        }
    }
}
