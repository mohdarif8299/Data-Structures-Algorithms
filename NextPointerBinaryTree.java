/**
 * Definition for binary tree with next pointer.
 * public class TreeLinkNode {
 *     int val;
 *     TreeLinkNode left, right, next;
 *     TreeLinkNode(int x) { val = x; }
 * }
 */
public class Solution {
    public void connect(TreeLinkNode root) {
        Queue<TreeLinkNode> queue = new LinkedList<>();
        root.next = null;
        queue.add(root);
        while(!queue.isEmpty()) {
            int x = queue.size();
            for(int i=0;i<x;i++) {
                
                TreeLinkNode node = queue.poll();
                if(i==x-1) {
                    node.next=null;
                }
                else {
                    node.next = queue.peek();
                }
                if(node.left!=null) 
                    queue.add(node.left);
                if (node.right!=null)
                    queue.add(node.right);
            }
        }
    }
}
