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
    public int solve(TreeNode A, TreeNode B) {
        HashSet<Integer> hashSet = inOrderA(A,new HashSet<>());
       // System.out.println(hashSet);
        long sum = inOrderB(B,hashSet,0L);
        return (int)(sum%1000000007);
    }
    public static HashSet<Integer> inOrderA(TreeNode A,HashSet<Integer> hashSet) {
        if(A==null) return hashSet;
        inOrderA(A.left,hashSet);
        hashSet.add(A.val);
        inOrderA(A.right,hashSet);
        return hashSet;
    }
    public static long inOrderB(TreeNode B,HashSet<Integer> hashSet,long sum) {
        if(B==null) return sum;
        sum = inOrderB(B.left,hashSet,sum);
        if(hashSet.contains(B.val)) sum+=B.val;
         sum = inOrderB(B.right,hashSet,sum);
        return sum;
    }
    
}
