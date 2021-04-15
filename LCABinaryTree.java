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
    Stack<Integer> pathA = new Stack<>();
    Stack<Integer> pathB = new Stack<>();
    ArrayList<Integer> aPath = new ArrayList<>();
    ArrayList<Integer> bPath = new ArrayList<>();
    public int lca(TreeNode A, int B, int C) {
        if(!existPathA(A,B)|| !existPathB(A,C)) return -1;
        while(!pathA.isEmpty()) {
            aPath.add(pathA.pop());
        }
        while(!pathB.isEmpty()) {
            bPath.add(pathB.pop());
        }
        int i=0;
        for(i=0;i<aPath.size() && i<bPath.size();i++) {
            if(!aPath.get(i).equals(bPath.get(i))) break;
        }
        return aPath.get(i-1);
    }
    public boolean existPathA(TreeNode A,int path) {
        if(A==null) return false;
        if(A.val == path) {
            pathA.push(A.val);
            return true;
        }
        boolean isExsist = existPathA(A.left,path) || existPathA(A.right,path);
        if(isExsist) pathA.push(A.val);
        return isExsist;
    }
    public boolean existPathB(TreeNode A,int path) {
        if(A==null) return false;
        if(A.val == path) {
            pathB.push(A.val);
            return true;
        }
        boolean isExsist = existPathB(A.left,path) || existPathB(A.right,path);
        if(isExsist) pathB.push(A.val);
        return isExsist;
    }
    
}
