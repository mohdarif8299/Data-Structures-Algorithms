public class Solution {
    public ArrayList<Integer> subUnsort(ArrayList<Integer> A) {
        int R=-1,L=-1;
        for(int i=0;i<A.size()-1;i++) {
            if(A.get(i)>A.get(i+1)) {
                L=i;
                break;
            }
        }
        for(int i=A.size()-2;i>=0;i--) {
            if(A.get(i)>A.get(i+1)) {
                R=i+1;
                break;
            }
        }
        ArrayList<Integer> ans = new ArrayList<>();
        if(L==-1||R==-1) {
            ans.add(-1);
            return ans;
        }
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;
        for(int i=L;i<=R;i++) {
            max = Math.max(max,A.get(i));
              min = Math.min(min,A.get(i));
        }
        for(int i=0;i<A.size();i++) {
            if(A.get(i)>min) {
                L = i;
                break;
            }
        }
        for(int i=A.size()-1;i>=0;i--) {
            if(A.get(i)<max) {
                R = i;
                break;
            }
        }
        ans.add(L);
        ans.add(R);
        return ans;
    }
}
