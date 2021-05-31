public class Solution {
    public ArrayList<ArrayList<Integer>> permute(ArrayList<Integer> A) {
        int N = A.size();
        ArrayList<Integer> al = new ArrayList<>();
        for(int i=0;i<N;i++) al.add(-1);
        return new ArrayList<ArrayList<Integer>>(permutation(0,N,A,al,new HashSet<>()));
    }
    public static Set<ArrayList<Integer>> permutation(int i,int N,ArrayList<Integer> A,ArrayList<Integer> al,Set<ArrayList<Integer>> set) {
     if(i==N) {
         set.add(al);
         return set;
     }   
     for(int j=0;j<N;j++) {
         if(al.get(j)==-1) {
            al.set(j,A.get(i));
            permutation(i+1,N,A,new ArrayList<>(al),set);
            al.set(j,-1);
         }
     }
     return set;
    }
}
