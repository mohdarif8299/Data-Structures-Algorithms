import java.util.*;
public class MinStack {
    private static Stack<Integer> stack = new Stack<>();
    private static Stack<Integer> minStack = new Stack<>();
    private static Integer min = Integer.MAX_VALUE;
    public static void main(String[] args) {
        pop(); 
        push(644643544);
        // push(2);
        // push(-2);
        System.out.println(getMin());
        //pop();
      //  System.out.println(getMin());
       System.out.println(top());
       System.out.println(top());
       System.out.println(top());
       pop();
       push(723943208);
       pop();
       push(909204);
       System.out.println(getMin());
    }
    public static void push(int x) {
        if(minStack.isEmpty()) minStack.push(x);
        else if(x<=minStack.peek()) {
            minStack.push(x);
        }
        stack.push(x);
    }

    public static void pop() {
        if(stack.isEmpty()) {
            return;
        }
        int temp = stack.pop();
        if(!minStack.isEmpty()) {
                if(temp == minStack.peek()) {
                minStack.pop();
            }
        }

    }

    public static int top() {
        if(stack.isEmpty()) return -1;
        return stack.peek();
    }

    public static int getMin() {
        if(minStack.isEmpty()) return -1;
        return minStack.peek();
    }
}