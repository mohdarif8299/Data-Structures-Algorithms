import java.util.*;
public class LongestSubsequence {
    public static void main(String[] args) {
        int A[] = {4,3,2,-2,-3,5,-3,1,2,3};
        System.out.println(Arrays.toString(solve(A)));
    }
    public static int[] solve(int A[]) {
        int index1=0,index2=0;
        int prefix[] = new int[A.length];
        prefix[0] = A[0];
        for(int i=1;i<A.length;i++) prefix[i] = prefix[i-1]+A[i];
        Map<Integer,Integer> map = new HashMap<>();
        int ans = 0;
        for(int i=0;i<prefix.length;i++) {
            if(prefix[i]==0) {
               if(ans<i+1) {
                ans = i+1;
                index2 = i+1;
                index1 = 0;
               }
            }
            if(map.containsKey(prefix[i])) {
                if(ans<i-map.get(prefix[i])) {
                    ans = i-map.get(prefix[i]);
                    index2 = i;
                    index1 = map.get(prefix[i])+1;
                }
            } else map.put(prefix[i],i);
        }
        int ARR[] = new int[ans];
        for(int i=0;i<ARR.length;i++) {
            ARR[i] = A[index1+i];
        }
        return ARR;
    }
}