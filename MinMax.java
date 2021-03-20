import java.util.*;
public class MinMax {
    public static void main(String[] args) {
      int A[] = {4, 7, 3, 8};  
      System.out.println(solve(A));  
    }
    public static int solve(int A[]) {
        long maxSum = 0;
        long minSum = 0;
        long totalSum = 0;
        int NG[] = nextGreater(A);
        int PG[] = previousGreater(A);
        int PS[] = prevSmaller(A);
        int NS[] = nextSmaller(A);
        
        for(int i=0;i<A.length;i++) {
           maxSum=1L*A[i]*(i-PG[i])*(NG[i]-i);
           minSum=1L*A[i]*(i-PS[i])*(NS[i]-i);
           totalSum+=(maxSum-minSum);
        }

        return (int)totalSum;
    }
    public static int[] nextGreater(int A[]) {
        int AR[] = new int[A.length];
        Arrays.fill(AR,A.length);
        Stack<Integer> stack = new Stack<>();
        for(int i=0;i<A.length;i++) {
            if(stack.isEmpty()) {
                stack.push(i);
            }
            else {
                if(A[stack.peek()]>A[i]) {
                    stack.push(i);
                }
                else {
                    while(!stack.isEmpty() && A[stack.peek()]<A[i]) {
                        AR[stack.pop()] = i;
                    }
                    stack.push(i);
                }
            }
        }
        return AR;
    }
    public static int[] previousGreater(int A[]) {
        int AR[] = new int[A.length];
        Arrays.fill(AR,-1);
        Stack<Integer> stack = new Stack<>();
        for(int i=A.length-1;i>=0;i--) {
            if(stack.isEmpty()) {
                stack.push(i);
            }
            else {
                if(A[stack.peek()]>A[i]) {
                    stack.push(i);
                }
                else {
                    while(!stack.isEmpty() && A[stack.peek()]<A[i]) {
                        AR[stack.pop()] = i;
                    }
                    stack.push(i);
                }
            }
        }
        return AR;

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