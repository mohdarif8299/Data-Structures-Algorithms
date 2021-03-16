import java.util.*;
public class BalancedBrackets {
    public static void main(String[] args) {
        String S= "}}}}";
        System.out.println(solve(S));
    }
    public static int solve(String A) {
        Stack<Character> stack = new Stack<>();
        for(int i=0;i<A.length();i++) {
            if(A.charAt(i)==']'  && !stack.isEmpty()) {
                char c = stack.pop();
                if(c=='[') continue;
                else return 0;
            }
            else if(A.charAt(i)=='}'  && !stack.isEmpty()) {
                char c = stack.pop();
                if(c=='{') continue;
                else return 0;
            }
            else if(A.charAt(i)==')' && !stack.isEmpty()) {
                char c = stack.pop();
                if(c=='(') continue;
                else return 0;
            }
            else {
                stack.push(A.charAt(i));
            }
        }
        return stack.isEmpty()?1:0;
    }
}