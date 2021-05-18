/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Codec {
    
    // Encodes a tree to a single string.
    public ArrayList<Integer> serialize(TreeNode root) {
        if(root==null) return null;
        ArrayList<Integer> sb= new ArrayList<>();
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while(!queue.isEmpty()) {
            TreeNode node = queue.poll();
             if(node==null){ 
                 sb.add(null); 
             }
             else {
                 sb.add(node.val);
                 queue.add(node.left);
                 queue.add(node.right);
             }
        }
        return sb;
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(ArrayList<Integer> data) {
        if(data==null) return null;
        TreeNode root = new TreeNode(data.get(0));
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        for(int i=1;i<data.size();i+=2) {
            TreeNode node = queue.poll();
            if(data.get(i)!=null) {
                TreeNode left = new TreeNode(data.get(i));
                node.left = left;
                queue.add(left);
            }
            if(data.get(i+1)!=null) {
                TreeNode right = new TreeNode(data.get(i+1));
                node.right = right;
                queue.add(right);
            }
        }
        return root;
    }
}

// Your Codec object will be instantiated and called as such:
// Codec ser = new Codec();
// Codec deser = new Codec();
// TreeNode ans = deser.deserialize(ser.serialize(root));
