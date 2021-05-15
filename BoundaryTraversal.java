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
    public static class Pair {
        int level;
        TreeNode A;
        Pair(int level,TreeNode A) {
            this.level = level;
            this.A = A;
        }
    }
    public ArrayList<Integer> solve(TreeNode A) {
        Map<Integer,TreeNode> map = new HashMap<>();
        map.put(0,A);
         Map<Integer,TreeNode> map2 = new HashMap<>();
        map2.put(0,A);
        Map<Integer,TreeNode> leftMap = getLeftView(A,map,0);
        Map<Integer,TreeNode> rightMap = getRightView(A,map2,0);
        ArrayList<Integer> leafNodes = getLeafNodes(A,new ArrayList<Integer>());
        Set<Integer> leftSide = new LinkedHashSet<>();
        for(Map.Entry<Integer,TreeNode> entry:leftMap.entrySet()) {
            leftSide.add(entry.getValue().val);
        }
        Set<Integer> rightSide = new LinkedHashSet<>();
        for(Map.Entry<Integer,TreeNode> entry:rightMap.entrySet()) {
            rightSide.add(entry.getValue().val);
        }
        ArrayList<Integer> arrayList = new ArrayList<>(rightSide);
        
        Set<Integer> list = new LinkedHashSet<>();
        Collections.reverse(arrayList);
        list.addAll(leftSide);
        list.addAll(leafNodes);
        list.addAll(arrayList);
        return new ArrayList<>(list);
    }
    public static Map<Integer,TreeNode> getLeftView(TreeNode A,Map<Integer,TreeNode> map,int level) {
        if(A==null) return map;
        if(!map.containsKey(level)) {
            map.put(level,A);
        }
        getLeftView(A.left,map,level+1);
        getLeftView(A.right,map,level+1);
        return map;
    }
    public static Map<Integer,TreeNode> getRightView(TreeNode A,Map<Integer,TreeNode> map,int level) {
        if(A==null) return map;
        map.put(level,A);
        getRightView(A.left,map,level+1);
        getRightView(A.right,map,level+1);
        return map;
    }
    public static ArrayList<Integer> getLeafNodes(TreeNode A,ArrayList<Integer> al) {
        if(A==null) return al;
        if(A.left==null && A.right==null) al.add(A.val);
        getLeafNodes(A.left,al);
        getLeafNodes(A.right,al);
        return al;
    }
}
