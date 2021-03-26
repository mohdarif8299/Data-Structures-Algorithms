import java.util.*;
public class MaxRectangle {
    public static void main(String[] args) {
        int A[][] = {{0,0,1},{0,1,1},{1,1,1}};
        System.out.println(solve(A));
    }
    public static int solve(int A[][]) {
        int max = Integer.MIN_VALUE;
        int temp[] = new int[A[0].length]; 
        for(int i=0;i<A.length;i++) {
            for(int j=0;j<A[i].length;j++) {
                if(i==0) {
                    temp = A[i];
                } else  {
                    if(A[i][j]==0) {
                        temp[j] = 0;
                    }
                    else {
                        temp[j] += A[i][j];
                    }
                }
            }
            int ps[] = previousSmaller(temp);
            int ns[] = nextSmaller(temp);
            for(int k=0;k<ps.length;k++) {
                max = Math.max(max,temp[k]*(ns[k]-ps[k]-1));
            }
        }
        return max;
    }
    public static int[] previousSmaller(int ARR[]) {
        int ANS[] = new int[ARR.length];
        Stack<Integer> stack = new Stack<>();
        for(int i=ARR.length-1;i>=0;i--) {
            if(stack.isEmpty()) {
                stack.push(i);
            }
            else if(ARR[i]<ARR[stack.peek()]) {
                while(!stack.isEmpty() && ARR[i]<ARR[stack.peek()]) {
                    ANS[stack.pop()] = i;
                }
                stack.push(i);
            }
            else stack.push(i);
        }
        while(!stack.isEmpty()) {
            ANS[stack.pop()] = -1;
        }
        return ANS;
    }
    public static int[] nextSmaller(int ARR[]) {
        int ANS[] = new int[ARR.length];
        Stack<Integer> stack = new Stack<>();
        for(int i=0;i<ARR.length;i++) {
            if(stack.isEmpty()) {
                stack.push(i);
            }
            else if(ARR[i]<ARR[stack.peek()]) {
                while(!stack.isEmpty() && ARR[i]<ARR[stack.peek()]) {
                    ANS[stack.pop()] = i;
                }
                stack.push(i);
            }
            else stack.push(i);
        }
        while(!stack.isEmpty()) {
            ANS[stack.pop()] = ARR.length;
        }
        return ANS;
    }

}