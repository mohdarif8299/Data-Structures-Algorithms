import java.util.*;
public class OrderThem {
    public static void main(String[] args) {
        int A[] = {1,2,3};
        System.out.println(solve(A));
    }   
    public static int solve(int A[]) {
        Stack<Integer> stack = new Stack<>();
        int B[] = new int[A.length];
        int k=0;
        for(int i=0;i<A.length-1;i++) {
            if(A[i]>A[i+1]) {
                if(stack.isEmpty())
                stack.push(A[i]);
                else if(A[i]<=stack.peek()) {
                    stack.push(A[i]);
                }
                else {
                    B[k++] = stack.pop();
                    stack.push(A[i]);
                }
            }
            else { 
                    B[k++] = A[i];
            }
        }
        if(stack.isEmpty()) {
            B[k++] = A[A.length-1];
        }
        else if( A[A.length-1]<=stack.peek()) {
            stack.push(A[A.length-1]);
        }
        else B[k++] = stack.pop();
        while(!stack.isEmpty()) {
            B[k++] = stack.pop();
        }
        for(int i=0;i<B.length-1;i++){
            if(B[i]>B[i+1]) return 0;
        }
        return 1;
    }
}