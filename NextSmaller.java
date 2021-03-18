import java.util.*;
public class NextGreater {
    public static void main(String[] args) {
        int A[] = {4, 5, 2, 10, 8};
        System.out.println(Arrays.toString(solve(A)));
    }
    public static int[] solve(int A[]) {
        int AR[] = new int[A.length];
        Arrays.fill(AR,-1);
        Stack<Integer> stack = new Stack<>();
        for(int i=0;i<A.length;i++) {
            if(stack.isEmpty()) {
                stack.push(i);
            }
            else {
                while(!stack.isEmpty() && A[i]<A[stack.peek()]) {
                    AR[stack.peek()] = A[i];
                    stack.pop();
                }
              
                stack.push(i);
            }
        }
        return AR;
    }
}