import java.util.*;
public class TwoSum {
    public static void main(String[] args) {
        Integer A[] = {1,1,1};
        ArrayList<Integer> Al = new ArrayList<>(Arrays.asList(A));
        int B = 2;
        System.out.println(solve(Al,B));
    }
    public static ArrayList<Integer> solve(ArrayList<Integer> A,int B) {
        int indexI=A.size(),indexJ=A.size();
        int element=Integer.MIN_VALUE;
        Map<Integer,Integer> map = new HashMap<>();
        ArrayList<Integer> Ans = new ArrayList<>();
        for(int i=0;i<A.size();i++) {
            int X = B-A.get(i);
            if(map.containsKey(X)) {
                indexI = map.get(X);
                indexJ = i;
                break;
            }
            else {
                if(map.containsKey(A.get(i))) continue;
                map.put(A.get(i),i);
            }
        }
        if(indexI==A.size() || indexJ==A.size()) return Ans;
        Ans.add(indexI+1);
        Ans.add(indexJ+1);
        return Ans;
    }
}