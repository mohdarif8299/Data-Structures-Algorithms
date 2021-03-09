import java.util.*;
public class DistributeCandies {
    public static void main(String[] args) {
        int A[] = {1,1,2,3};
        System.out.println(solve(A));
    }
    public static int solve(int A[]) {
        int countCandies = 0;
        int count = A.length/2;
        Map<Integer,Integer> map = new HashMap<>();
        for(int i=0;i<A.length;i++) {
            if(map.containsKey(A[i]))
                map.put(A[i],map.get(A[i])+1); 
            else 
            map.put(A[i],1);
        }
        if(map.size()<=count) return map.size();
        if(map.size()>count) return count;
        return countCandies;
    }
}