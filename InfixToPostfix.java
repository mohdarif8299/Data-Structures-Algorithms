import java.util.*;
public class InfixToPostfix {
    public static void main(String[] args) {
        String A = "a+b*(c^d-e)^(f+g*h)-i";
        System.out.println(solve(A));
    }
    public static String solve(String A) {
        A = "("+A+")";
        Stack<Character> stack = new Stack<>();
        StringBuilder sb = new StringBuilder("");
        for(int i=0;i<A.length();i++) {
            if(isOperator(A.charAt(i))) {
                if(A.charAt(i)==')') {
                    while(!stack.isEmpty() &&  stack.peek()!='(') {
                        char ch = stack.pop();
                        sb.append(ch);
                    }
                    stack.pop();
                }
                else if(!stack.isEmpty() && getPrecedence(A.charAt(i))>0 && getPrecedence(stack.peek())>=getPrecedence(A.charAt(i))) {
                    while(!stack.isEmpty() && getPrecedence(A.charAt(i))>0  && getPrecedence(stack.peek())>=getPrecedence(A.charAt(i))) {
                        char ch = stack.pop();
                        sb.append(ch);
                    }
                    stack.push(A.charAt(i));
                }
                else {
                    stack.push(A.charAt(i));
                }
            }
            else {
                sb.append(A.charAt(i));
            }
        }
        return sb+"";
    }
    public static boolean isOperator(char ch) {
        if(ch=='+' || ch=='-' || ch=='*' || ch=='^' || ch=='/' || ch==')' || ch=='(') return true;
        return false;
    }
    public static int getPrecedence(char ch) {
        if(ch=='^') return 3;
        else if(ch=='/' || ch=='*') return 2;
        else if(ch=='+' || ch=='-') return 1;
        return 0;
    }
}