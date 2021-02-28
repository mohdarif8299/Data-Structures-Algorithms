import java.util.*;
public class NumberSmallerThanCurrentNumber {
    public static void main(String[] args) {
        int A[] = {8,1,2,2,3};
        System.out.println(Arrays.toString(solve(A)));
    }
    public static int[] solve(int A[]) {
        int ARR[] = Arrays.copyOf(A,A.length);
        Map<Integer,Integer> map = new HashMap<>();
        Arrays.sort(ARR);
        for(int i=ARR.length-1;i>=0;i--) {
            map.put(ARR[i],i);
        }
        for(int i=0;i<A.length;i++) {
            A[i] = map.get(A[i]);
        }
        return A;
    }
}