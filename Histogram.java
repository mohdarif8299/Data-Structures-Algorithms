import java.util.*;
public class Histogram {
    public static void main(String[] args) {
        int A[] = {6};
        System.out.println(solve(A));
    }

    public static int solve(int A[]) {
        int N[] = nextSmaller(A);
        int P[] = prevSmaller(A);
        long max = Integer.MIN_VALUE;
        for(int i=0;i<A.length;i++) {
            max = Math.max(max,1L*A[i]*(N[i]-P[i]-1));
        }
        return (int)max;
    }

    public static int[] nextSmaller(int A[]) {
        int AR[] = new int[A.length];
        Arrays.fill(AR,A.length);
        Stack<Integer> stack = new Stack<>();
        for(int i=0;i<A.length;i++) {
            if(stack.isEmpty()) {
                stack.push(i);
            }
            else {
                if(A[stack.peek()]<A[i]) {
                    stack.push(i);
                }
                else {
                    while(!stack.isEmpty() && A[stack.peek()]>A[i]) {
                        AR[stack.pop()] = i;
                    }
                    stack.push(i);
                }
            }
        }
        return AR;
    }
    public static int[] prevSmaller(int A[]) {
        int AR[] = new int[A.length];
        Arrays.fill(AR,-1);
        Stack<Integer> stack = new Stack<>();
        for(int i=A.length-1;i>=0;i--) {
            if(stack.isEmpty()) {
                stack.push(i);
            }
            else {
                if(A[stack.peek()]<A[i]) {
                    stack.push(i);
                }
                else {
                    while(!stack.isEmpty() && A[stack.peek()]>A[i]) {
                        AR[stack.pop()] = i;
                    }
                    stack.push(i);
                }
            }
        }
        return AR;
    }
}