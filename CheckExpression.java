import java.util.*;
public class CheckExpression {
    public static void main(String[] args) {
        String A = "-(a-(-z-(b-(c+t)-x)+l)-q)";
        String B = "-a+l-b-(z-(c+t)-x-q)";
        System.out.println(solve(A,B));
    }
    public static int solve(String A,String B) {
        int AR[] = getExpressionSign(A);
        int BR[] = getExpressionSign(B);
        for(int i=0;i<26;i++) if(AR[i]!=BR[i]) return 0;
        return 1;
    }
    public static int[] getExpressionSign(String A) {
        int ch[] = new int[26];
        Stack<Integer> stack = new Stack<>();
        stack.push(1);
        StringBuilder sb = new StringBuilder();
        for(int i=0;i<A.length();i++) {
            if(A.charAt(i)=='(') {
                if(i==0) stack.push(stack.peek()); 
                else stack.push(stack.peek()*getSignValue(A.charAt(i-1)));
            }
            else if(A.charAt(i)>=97 && A.charAt(i)<=122) {
                 if(i==0) ch[A.charAt(i)-'a'] = stack.peek();
                 else ch[A.charAt(i)-'a'] = stack.peek()*getSignValue(A.charAt(i-1));
            }
            else if(A.charAt(i)==')') stack.pop();
        }
        return ch;
    }
    public static int getSignValue(char c) {
        return c=='-'?-1:1;
    }
}