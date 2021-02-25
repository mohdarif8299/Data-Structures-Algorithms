import java.util.*;
public class GoodPairs {
    public static void main(String[] args) {
        int A[] = {1,2,3,1,1,3};
        System.out.println(solve(A));
    }
    public static int solve(int A[]) {
        int count=0;
        Map<Integer,Integer> map = new HashMap<>();
        for(int i=0;i<A.length;i++) {
           if(map.containsKey(A[i])) map.put(A[i],map.get(A[i])+1);
           else map.put(A[i],1);
        }
        Set<Integer> set = map.keySet();
        for(Integer i:set) {
            int X = map.get(i);
            count+=(X*(X-1))/2;
        }
        return count;
    }
}