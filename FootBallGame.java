import java.util.*;
public class FootBallGame {
    public static Stack<Integer> stack = new Stack<>();
    public static void main(String[] args) {
        int A = 1;
        int B = 10;
        int C[] = {0};
        System.out.println(solve(A,B,C));
    }
    public static int solve(int A,int B,int C[]) {
        stack.push(B);
        for(int i=0;i<C.length;i++) {
            if(C[i]!=0) {
                stack.push(C[i]);
            }
            else {
                stack.pop();
            }
        }
        return stack.peek();
    }
    
}