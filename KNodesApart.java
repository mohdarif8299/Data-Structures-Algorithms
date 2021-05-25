import java.lang.*;
import java.util.*;

public class Main {
    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int val) {
            this.val = val;
        }
    }
    public static ArrayList<TreeNode> path;
    public static void main(String[] args) {
        // YOUR CODE GOES HERE
        // Please take input and print output to standard input/output (stdin/stdout)
        // DO NOT USE ARGUMENTS FOR INPUTS
        // E.g. 'Scanner' for input & 'System.out' for output
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int A[] = new int[N];
        for(int i=0;i<N;i++) A[i] = sc.nextInt();
        int X = sc.nextInt();
        int K = sc.nextInt();
        TreeNode root = deserialize(A);
        printKNode(root,X,K);
    }
    
    public static TreeNode deserialize(int data[]) {
        if(data==null) return null;
        TreeNode root = new TreeNode(data[0]);
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        for(int i=1;i<data.length;i+=2) {
            TreeNode node = queue.poll();
            if(data[i]!=-1) {
                TreeNode left = new TreeNode(data[i]);
                node.left = left;
                queue.add(left);
            }
            if(data[i+1]!=-1) {
                TreeNode right = new TreeNode(data[i+1]);
                node.right = right;
                queue.add(right);
            }
        }
        return root;
    }
    public static void printKNode(TreeNode root,int X,int K) {
        path = new ArrayList<>();
        rootPath(root,X);
        for(int i=0;i<path.size();i++) {
            kDown(path.get(i),K-i,i==0?null:path.get(i-1));
        }
    }
    public static boolean rootPath(TreeNode root,int x) {
        if(root==null) return false;
        if(root.val==x) { 
            path.add(root);
            return true;
        }
        boolean left = rootPath(root.left,x) ;
        if(left) {
            path.add(root);
            return true;
        }
        boolean right = rootPath(root.right,x) ;
        if(right) {
            path.add(root);
            return true;
        }
        return false;
    }
    public static void kDown(TreeNode root,int k,TreeNode blocker) {
        if(root==null || k<0 || root==blocker) return;
        if(k==0) System.out.println(root.val);
        kDown(root.left,k-1,blocker);
        kDown(root.right,k-1,blocker);
    }
}
