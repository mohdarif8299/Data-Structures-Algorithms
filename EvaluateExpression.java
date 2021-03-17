import java.util.*;
public class EvaluateExpression {
    public static void main(String[] args) {
        String[] A = {"2", "2", "/"};
        System.out.println(solve(A));
    }
    public static int solve(String[] A) {
        Stack<String> stack = new Stack<>();
        for(int i=0;i<A.length;i++) {
            if(A[i]=="+" || A[i]=="-" || A[i]=="*" || A[i]=="/" ) {
                int op2 = Integer.parseInt(stack.pop());
                int op1 = Integer.parseInt(stack.pop());
                int result = 0;
                if(A[i]=="+") result = op1+op2;
                else if(A[i]=="-") result = op1+op2;
                else if(A[i]=="*") result = op1*op2;
                else result = op1/op2;

                stack.push(result+"");

            }
            else {
                stack.push(A[i]);
            }
        }
        return Integer.parseInt(stack.peek());
    }
}