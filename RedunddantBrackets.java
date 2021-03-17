import java.util.*;
public class RedunddantBrackets {
    public static void main(String[] args) {
        String A = "(c+(a+b))";
        System.out.println(solve(A));
    }
    public static int solve(String A) {
        Stack<Character> stack = new Stack<>();
        int count = 1;
        for(int i=0;i<A.length();i++) {
            if(A.charAt(i)==')' && !stack.isEmpty()) {
                char ch = stack.peek();
                if(ch=='(') return 1;
                    while(stack.peek()!='(') {
                        stack.pop();
                    }
                    stack.pop();
                
            }
            else if(A.charAt(i)=='+' || A.charAt(i)=='-' || A.charAt(i)=='*' || A.charAt(i)=='/' || A.charAt(i)=='(') {
                stack.push(A.charAt(i));
            }
        }
        return 0;
    }
}