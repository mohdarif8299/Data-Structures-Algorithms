    /*
    Definition for TreeNode.
    static public class TreeNode {
        public int val;
        public TreeNode left;
        public TreeNode right;
        TreeNode() {}
        TreeNode(int val) { this.val = val; this.depth = -1;}
    }
    */

    static void solve(TreeNode A){
         A.depth=1;
         fillDepthNode(A);
    }
    public static void fillDepthNode(TreeNode A) {
        if(A==null) return;
        if(A.left!=null)
        A.left.depth = A.depth+1;
        if(A.right!=null)
        A.right.depth = A.depth+1;
        fillDepthNode(A.left);
        fillDepthNode(A.right);
    }

        
