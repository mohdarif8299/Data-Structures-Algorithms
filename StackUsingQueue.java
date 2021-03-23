import java.util.*;
public class StackUsingQueue {
    public static Deque<Integer> queue = new LinkedList<>();
    public static void main(String[] args) {
        push(20);
        System.out.println(empty());
        System.out.println(top());
        System.out.println(pop());
        System.out.println(empty());
        push(30);
        System.out.println(top());
        push(40);
        System.out.println(top());
    }
    /** Push element X onto stack. */
    public static void push(int X) {
        queue.addLast(X);
    }
    
    /** Removes the element on top of the stack and returns that element. */
    public static int pop() {
      return queue.removeLast();
    }
    
    /** Get the top element of the stack. */
    public static int top() {
        return queue.getLast();
    }
    
    /** Returns whether the stack is empty. */
    public static boolean empty() {
        return queue.isEmpty();
    }
}