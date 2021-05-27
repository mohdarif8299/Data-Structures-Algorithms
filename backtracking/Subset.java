import java.util.*;
public class Solution {
    public ArrayList<ArrayList<Integer>> subsets(ArrayList<Integer> A) {
        Collections.sort(A);
        return print(0,A.size(),A,new ArrayList<Integer>(),new ArrayList<ArrayList<Integer>>());
    }
    public static ArrayList<ArrayList<Integer>> print(int index,int N,ArrayList<Integer> A,ArrayList<Integer> ANS,ArrayList<ArrayList<Integer>> subset) {
        subset.add(ANS);
        for(int i=index;i<N;i++) {
            ANS.add(A.get(i));
            print(i+1,N,A,new ArrayList<>(ANS),subset);
            ANS.remove(ANS.size()-1);
        }
        return subset;
    }
}
