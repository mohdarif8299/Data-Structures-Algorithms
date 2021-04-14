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
    public static class Pair {
        TreeNode treeNode;
        int level;
        Pair(TreeNode treeNode,int level) {
            this.treeNode = treeNode;
            this.level = level;
        }
    }
    public List<Integer> rightSideView(TreeNode A) {
        
        List<Integer> ans = new ArrayList<>();
        if(A==null) return ans;
        Map<Integer,Integer> map = new TreeMap<>();
        Queue<Pair> queue = new LinkedList<>();
        queue.add(new Pair(A,0));
        while(!queue.isEmpty()) {
            Pair pair = queue.poll();
            map.put(pair.level,pair.treeNode.val);
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
