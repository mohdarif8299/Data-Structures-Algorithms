import java.util.*;
public class InsertStackBottom {
    public static Stack<Integer> stack  = new Stack<>();
    public static void main(String[] args) {
        stack.push(5);stack.push(6);stack.push(1);
        System.out.println(insertAtBottom(stack,10));
    }
    public static Stack<Integer> insertAtBottom(Stack<Integer> stack,int X) {
        if(stack.isEmpty()) {
            stack.push(X);
           return stack;
        }
        int temp = stack.pop();
        insertAtBottom(stack,X);
        stack.push(temp);
        return stack;
    }
}