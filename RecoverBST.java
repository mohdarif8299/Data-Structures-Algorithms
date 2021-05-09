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
    public ArrayList<Integer> recoverTree(TreeNode A) {
        ArrayList<Integer> inOrder = traverse(A,new ArrayList<>());
        ArrayList<Integer> afterSorting = new ArrayList<>(inOrder);
        Collections.sort(afterSorting);
        ArrayList<Integer> ans = new ArrayList<>();
        for(int i=0;i<inOrder.size();i++) {
            if(inOrder.get(i)!=afterSorting.get(i)) {
              if(inOrder.get(i)!=afterSorting.get(i)) {
                    if(inOrder.get(i)<afterSorting.get(i)) {
                        ans.add(inOrder.get(i));
                        ans.add(afterSorting.get(i));
                    } else {
                        ans.add(afterSorting.get(i));
                        ans.add(inOrder.get(i));
                    }
                    break;
              }
            }
        }
        return ans;
    }
    public static ArrayList<Integer> traverse(TreeNode A,ArrayList<Integer> a) {
       if(A==null) return null;
       traverse(A.left,a);
       a.add(A.val);
       traverse(A.right,a);
       return a;
    }
    
}
