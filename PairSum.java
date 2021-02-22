import java.util.*;
public class PairSum  {
    public static void main(String[] args) {
        int A[] = {9, 3, 14, 7, 8, 2, 5};
        System.out.println(solve(A));
    }
    public static int solve(int A[]) {
        int count=0;
        HashMap<Integer,Boolean> map = new HashMap<>();
        Arrays.sort(A);
        for(int i=0;i<A.length;i++) {
            map.put(A[i],true);
        }
        for(int i=A.length-1;i>=0;i--) {
            for(int j=0;j<A.length;j++) {
                   int X = A[i]-A[j];
                if(X!=A[j] && map.containsKey(X) && map.get(X)==true) {
                    count+=1;
                    map.put(X,false);
                    map.put(A[j],false);
             }   

          }
          for(int k=0;k<A.length;k++) {
            map.put(A[k],true);
        }

        }
        return count;
    }
}