class Solution{
    
    static int sum=0;
    // modify the BST and return its root
    public Node modify(Node root)
    {
        sum=0;
        sum(root);
        return root;
        //Write your code here
        
    }
    public static void sum(Node root) {
        if(root==null) return;
        sum(root.right);
        sum+=root.data;
        root.data = sum;
        sum(root.left);
    }
    
}
