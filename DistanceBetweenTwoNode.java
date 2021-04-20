public class Solution {
    int ans=0;
    public int solve(TreeNode A, int B, int C) {
        TreeNode P=getLCA(A,B,C);

		getPath(P, B);
		getPath(P, C);
	
		return ans-2;
    }
     public TreeNode getLCA(TreeNode A,int B,int C){
        if(A==null || A.val==B || A.val==C) return A;
        
        TreeNode nodeLeft=getLCA(A.left,B,C);
        
        TreeNode nodeRight=getLCA(A.right,B,C);
        
        if(nodeLeft!=null && nodeRight!=null) return A; 
        
        return nodeLeft==null? nodeRight : nodeLeft;
    }
    public boolean getPath(TreeNode A, int x) {
		if (A == null)
			return false;
		if (A.val == x) {
			ans+=1;
			return true;
		}

		boolean nodeLeft = getPath(A.left, x);
		boolean nodeRight = getPath(A.right, x);

		if (nodeLeft || nodeRight) {
			ans+=1;
			return true;
		}
		return false;
	}
}
