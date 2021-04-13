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
            this.level= level;
        }
    }
    public ArrayList<ArrayList<Integer>> verticalOrderTraversal(TreeNode A) {
          ArrayList<ArrayList<Integer>> ans = new ArrayList<>();
        if(A==null) return ans;
        Queue<Pair> queue = new LinkedList<>();
        Map<Integer,ArrayList<Integer>> map = new TreeMap<>();
        queue.add(new Pair(A,0));
        while(!queue.isEmpty()) {
            Pair p = queue.poll();
            if(map.containsKey(p.level)) {
              ArrayList<Integer> al =  map.get(p.level);
              al.add(p.treeNode.val);
              map.put(p.level,al);
            }
            else {
                ArrayList<Integer> al = new ArrayList<>();
                al.add(p.treeNode.val);
                map.put(p.level,al);
            }
            if(p.treeNode.left!=null) queue.add(new Pair(p.treeNode.left,p.level-1));
            if(p.treeNode.right!=null) queue.add(new Pair(p.treeNode.right,p.level+1));
        }
        ArrayList<Integer> keys = new ArrayList<>(map.keySet());
        for(int i=0;i<keys.size();i++) {
            if(keys.get(i)!=null)
            ans.add(map.get(keys.get(i)));
        }
        return ans;
    }
}
