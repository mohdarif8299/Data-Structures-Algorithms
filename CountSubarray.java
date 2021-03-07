import java.util.*;
public class CountSubarray {
    public static void main(String[] args) {
        int A[] = {1,2,3,4,5};
        System.out.println(solve(A));
    }
    public static int solve(int A[]) {
        Set<Integer> set = new HashSet<>();
        long subArrayCount = 0;
        set.add(A[0]);
        int i=0,j=1;
        while(i<j && j<A.length) {
            if(!set.contains(A[j])) {
                set.add(A[j]);
                j++;
                if(j==A.length) {
                    subArrayCount+=((j-i)*(j-i+1))/2;
                }
            }
            else {
                set.remove(A[i]);
                subArrayCount+=(j-i);
                i++;
            }
            
        }
        return (int)(subArrayCount%1000000007);
    }
}