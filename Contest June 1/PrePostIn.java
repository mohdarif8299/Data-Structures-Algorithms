public class Solution {
    public static Map<Integer,Integer> map;
    public static int index;
    public static class Node {
        int data;
        Node left;
        Node right;
        Node(int data) {
            this.data = data;
        }
    }
    public int solve(int[] A, int[] B, int[] C) {
       map = new HashMap<>();
       index=0;
       Node root = insertToMap(B,A);
       ArrayList<Integer> list = postOrder(root,new ArrayList<>());
       for(int i=0;i<list.size();i++) {
           if(C[i]!=list.get(i)) return 0;
       }
       return 1;
    }
    public static ArrayList<Integer> postOrder(Node root,ArrayList<Integer> list) {
        if(root==null) return list;
        postOrder(root.left,list);
        postOrder(root.right,list);
        list.add(root.data);
        return list;
    }
    public static Node build(int[] B,int[] A,int start,int end) {
        if(start>end) return null;
        Node node =null;
        if(index<A.length) {
            int num = A[index++];
            node = new Node(num);
            if(start==end) return node;
            int idx = map.get(num);
            node.left = build(B,A,start,idx-1);
           node.right = build(B,A,idx+1,end);
        }
        return node;
    } 
    public static Node insertToMap(int[] B,int[] A) {
        for(int i=0;i<B.length;i++) {
            map.put(B[i],i);
        }
        return build(B,A,0,A.length-1);
    }
    
}
