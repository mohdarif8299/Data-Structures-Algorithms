import java.util.*;
public class DoubleCharacterTouble {
    public static void main(String[] args) {
        String A = "ab";
        System.out.println(solve(A));
    }
    public static String solve(String A) {
        StringBuilder sb = new StringBuilder("");
        Stack<Character> stack = new Stack<>();
        for(int i=0;i<A.length();i++) {
            char ch = A.charAt(i);
            if(stack.isEmpty()) {
                stack.push(ch);
            }
            else {
                if(ch!=stack.peek()) {
                    stack.push(ch);
                }
                else {
                    while(!stack.isEmpty() && ch==stack.peek()) {
                        char c = stack.pop();
                    }
                }
            }
        }
        while(!stack.isEmpty()) {
            sb.append(stack.pop());
        }
        return sb.reverse()+"";
    }
}