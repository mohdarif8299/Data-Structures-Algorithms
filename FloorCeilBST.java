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
    public ArrayList<ArrayList<Integer>> solve(TreeNode A, ArrayList<Integer> B) {
        ArrayList<ArrayList<Integer>> ans = new ArrayList<>();
        ArrayList<Integer> inOrder = inOrderTraversal(A,new ArrayList<>());
        for(Integer i:B) {
            ArrayList<Integer> aList = new ArrayList<>();
            aList.add(getFloor(inOrder,i));
            aList.add(getCeil(inOrder,i));
            ans.add(aList);
        }
        return ans;
    }
    public static ArrayList<Integer> inOrderTraversal(TreeNode A,ArrayList<Integer> list) {
        if(A==null) {
            return null;
        }
        inOrderTraversal(A.left,list);
        list.add(A.val);
        inOrderTraversal(A.right,list);
        return list;
    }
    public static int getFloor(ArrayList<Integer> A,int key) {
        int low = 0,high = A.size()-1;
        int ans = -1;
        while(low<=high) {
            int mid = (low+high)/2;
            if(A.get(mid)==key) return A.get(mid);
            else if(A.get(mid)<key) {
                ans = A.get(mid);
                low = mid+1;
            }
            else {
                high = mid-1;
            }
        }
        return ans;
    }
    public static int getCeil(ArrayList<Integer> A,int key) {
        int low = 0,high = A.size()-1;
        int ans = -1;
        while(low<=high) {
            int mid = (low+high)/2;
            if(A.get(mid)==key) return A.get(mid);
            else if(A.get(mid)>key) {
                ans = A.get(mid);
                high = mid-1;
               
            }
            else {
                low = mid+1; 
            }
        }
        return ans;
    }
}
