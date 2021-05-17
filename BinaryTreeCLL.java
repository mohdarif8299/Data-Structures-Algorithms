/*
class TreeNode {
    int val;
    TreeNode left, right;
    ListNode(int x) {
        val = x;
        left = right = null;
    }
}
*/
TreeNode solve (TreeNode A) {
      ArrayList<TreeNode> list = inOrder(A,new ArrayList<>());
      if(list.size()==0) return null;
      TreeNode root = list.get(0);
      root.left = list.get(list.size()-1);
      TreeNode temp = root;
      for(int i=1;i<list.size();i++) {
          TreeNode node = list.get(i);
          temp.right = node;
          node.left = temp;
          temp = node;
      }
      return root;
}
private static ArrayList<TreeNode> inOrder(TreeNode A,ArrayList<TreeNode> al) {
    if(A==null) return al;
    inOrder(A.left,al);
    al.add(A);
    inOrder(A.right,al);
    return al;
}
