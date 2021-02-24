import java.util.*;
public class DiffK {
    public static void main(String[] args) {
        int A[] = {1, 5, 4, 1, 2};
        int K= 2;
        System.out.println(solve(A,K));
    }
    public static int solve(int A[],int B) {
        Map<Integer,Integer> map = new HashMap<>();
        Map<Integer,Integer> map2 = new HashMap<>();
        for(int i=0;i<A.length;i++) {
            if(map.containsKey(A[i])) {
                map2.put(A[i],i);
            }
            else {
                map.put(A[i],i);
                map2.put(A[i],i);
            }
            
        }
        for(int i=0;i<A.length;i++) {
            int X = A[i]+B;
            if(map.containsKey(X) && map.get(X)!=map2.get(A[i])) return 1;
        }
        return 0;
    }
}