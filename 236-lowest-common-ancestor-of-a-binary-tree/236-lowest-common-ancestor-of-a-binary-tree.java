/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
      return lca(root, p, q);
    }
    public static TreeNode lca(TreeNode root, TreeNode p, TreeNode q) {
       List<TreeNode> listA = new ArrayList<>();
       List<TreeNode> listB = new ArrayList<>();
       pathExists(root, p, listA);
       pathExists(root, q, listB);
       int i = 0; 
       int j = 0; 
        TreeNode node = null;
        while(i < listA.size() && j < listB.size()) {
            if(listA.get(i)!=listB.get(j)) return node;
            node = listA.get(i);
            i++; j++;
        }
       return node;
    }
    public static boolean pathExists(TreeNode node, TreeNode target, List<TreeNode> list) {
        if(node == null) return false;
        
        list.add(node);
        
        if(node.val == target.val) {
            return true;
        }
        
        boolean b = (pathExists(node.left, target, list) || pathExists(node.right, target, list));
        
        if(b) return true;
        list.remove(list.size()-1);
        return false;
        
        
    }
}