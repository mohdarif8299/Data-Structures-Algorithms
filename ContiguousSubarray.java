import java.util.*;
public class ContiguousSubarray {
    public static void main(String[] args) {
        int A[] = {0, 1, 1, 1, 1 };
        System.out.println(solve(A));
    }
    public static int solve(int A[]) {
        int count=0;
        for(int i=0;i<A.length;i++) A[i] = (A[i]==0)?-1:1;
        for(int i=1;i<A.length;i++) A[i] = A[i]+A[i-1];
        Map<Integer,Integer> map = new HashMap<>();
        for(int i=0;i<A.length;i++) {
            if(A[i]==0) {
                count = Math.max(count,i+1);
            }
            if(map.containsKey(A[i])) {
                count = Math.max(count,(i-map.get(A[i])));
            }
            else {
                map.put(A[i],i);
            }
        }
        return count;
    }

}