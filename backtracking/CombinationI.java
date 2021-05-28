public class Solution {
    public ArrayList<ArrayList<Integer>> combinationSum(ArrayList<Integer> A, int B) {
        Collections.sort(A);
        return count(0,A.size(),A,B,new ArrayList<>(),new ArrayList<ArrayList<Integer>>());
    }
    public static ArrayList<ArrayList<Integer>> count(int i,int N,ArrayList<Integer> A,int B,ArrayList<Integer> al,ArrayList<ArrayList<Integer>> ans) {
        if(i==N || B<0) return ans;
        if(B==0) {
            ans.add(al);
            return ans;
        }
        al.add(A.get(i));
        count(i,N,A,B-A.get(i),new ArrayList<>(al),ans);
        al.remove(al.size()-1);
        while(i<N-1 && A.get(i)==A.get(i+1))i++;
        count(i+1,N,A,B,new ArrayList<>(al),ans);
        return ans;
    }
}
