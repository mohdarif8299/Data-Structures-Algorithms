import java.util.*;
public class SortStackUsingAnotherStack {
    private static Stack<Integer> stack = new Stack<>();
    public static void main(String[] args) {
        int A[] = {5,4,3,2,1};
        System.out.println(Arrays.toString(solve(A)));
    }
    public static int[] solve(int A[]) {
        addArrayToStack(A,0);
        Stack<Integer> sortedStack = new Stack<>();
        while(!stack.isEmpty()) {
            int temp = stack.pop();
            if(sortedStack.isEmpty()) {
                sortedStack.push(temp);
            }
            else if(temp>=sortedStack.peek()) {
                sortedStack.push(temp);
            }
            else {
                while(!sortedStack.isEmpty() && sortedStack.peek()>temp) {
                    stack.push(sortedStack.pop());
                }
                sortedStack.push(temp);
            }
        }
        int i = A.length-1;
        while(!sortedStack.isEmpty()) {
            A[i--] = sortedStack.pop();
        }
         return A;
    }
    public static void addArrayToStack(int A[],int i) {
        if(i==A.length) return;
        stack.push(A[i]);
        addArrayToStack(A,i+1);
    }
}