import java.util.*;
public class ReverseStack {
    static Stack<Integer> stack1 = new Stack<>();
    public static void main(String[] args) {
        int A[] = {1,2,3,4,5};
        System.out.println(Arrays.toString(solve(A)));
    }
    public static int[] solve(int A[]) {
        Stack<Integer> stack = new Stack<>();
        addElement(A,0,stack);  
        Stack<Integer> ansStack = reverse(stack);
        return printElement(A,A.length-1,ansStack);
    }
    public static void addElement(int A[],int i,Stack<Integer> stack) {
        if(i==A.length) return;
        stack.push(A[i]);
        addElement(A,i+1,stack);
    }
    public static int[] printElement(int A[],int i,Stack<Integer> stack) {
        if(stack.isEmpty()) {
            return A;
        }
       int temp = stack.pop();
        printElement(A,i-1,stack);
        A[i] = temp;
        return A;
    }

    public static Stack<Integer> reverse(Stack<Integer> stack) {
        if(stack.isEmpty()) {
            return stack1;
        }
        stack1.push(stack.pop());
        reverse(stack);
        return stack1;
    }
}