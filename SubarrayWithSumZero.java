import java.util.*;
public class SubarrayWithSumZero {
    public static void main(String[] args) {
        int A[] = {5, 17, -22, 11};
        System.out.println(solve(A));
    }
    public static int solve(int A[]) {
        HashMap<Long,Integer> map = new HashMap<>();
        ArrayList<Long> Al = new ArrayList<>();
        Al.add(1L*A[0]);
        for(int i=1;i<A.length;i++) Al.add(Al.get(i-1)+A[i]); 
        System.out.println(Al);
        for(int i=0;i<A.length;i++) {
            if(1L*Al.get(i)==0L) return 1;
            else if(map.containsKey(Al.get(i))) return 1;
            else map.put(Al.get(i),i);
        }
        return 0;
    }
}