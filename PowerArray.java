public class Solution {
    public int solve(int[] A) {
        int nge[] = nextGreater(A);
        int pge[] = previousGreater(A);
        int ans=0;
        for(int i=0;i<A.length;i++) {
            ans+=(1L*nge[i]-i-1L)*(1L*i-pge[i]-1L);
            ans+=nge[i]-i-1L;
            ans+=i-pge[i]-1L;
        }
        return ans;
    }
    public static int[] nextGreater(int A[]) {
        int nge[] = new int[A.length];
        Stack<Integer> stack = new Stack<>();
        stack.push(0);
        for(int i=1;i<A.length;i++) {
            while(!stack.isEmpty() && A[stack.peek()]/2<A[i]) {
                nge[stack.pop()] = i;
            }
            stack.push(i);
        }
        while(!stack.isEmpty()) {
            nge[stack.pop()]=A.length;
        }
        return nge;
    }
    public static int[] previousGreater(int A[]) {
        int pge[] = new int[A.length];
        Stack<Integer> stack = new Stack<>();
        stack.push(A.length-1);
        for(int i=A.length-2;i>=0;i--) {
            while(!stack.isEmpty() && A[stack.peek()]/2<A[i]) {
                pge[stack.pop()] = i;
            }
            stack.push(i);
        }
        while(!stack.isEmpty()) {
            pge[stack.pop()]=-1;
        }
        return pge;
    }
}
