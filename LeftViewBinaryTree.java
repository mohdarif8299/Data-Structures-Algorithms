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
    public ArrayList<Integer> solve(TreeNode A) {
        ArrayList<Integer> ans = new ArrayList<>();
        Map<Integer,Integer> map = new TreeMap<>();
        Queue<Pair> queue = new LinkedList<>();
        queue.add(new Pair(A,0));
        while(!queue.isEmpty()) {
            Pair pair = queue.poll();
            if(!map.containsKey(pair.level)) {
                map.put(pair.level,pair.treeNode.val);
            }
            if(pair.treeNode.left!=null) queue.add(new Pair(pair.treeNode.left,pair.level+1));
            if(pair.treeNode.right!=null) queue.add(new Pair(pair.treeNode.right,pair.level+1));
        }
        ArrayList<Integer> keys = new ArrayList<>(map.keySet());
        for(int i=0;i<keys.size();i++) {
            ans.add(map.get(keys.get(i)));
        }
        return ans;
    }
}
