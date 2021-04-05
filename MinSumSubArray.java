class Solution {
    public int sumSubarrayMins(int[] A) {
        long sum = 0;
        int ns[] = nextSmaller(A);
        int ps[] = previousSmaller(A);
        for(int i=0;i<A.length;i++) {
            sum+=1L*A[i]*(i-ps[i])*(ns[i]-i);
        }
        return (int)(sum%1000000007);
    }
    public static int[] nextSmaller(int A[]) {
         int ps[]= new int[A.length];
        Stack<Integer> stack = new Stack<>();
        for(int i=0;i<A.length;i++) {
            if(stack.isEmpty() || A[stack.peek()]<A[i]) {
                stack.push(i);
            }
            else {
                while(!stack.isEmpty() && A[stack.peek()]>A[i]) {
                    ps[stack.pop()] = i;
                }
                stack.push(i);
            }
        }
        while(!stack.isEmpty()) {
            ps[stack.pop()] = ps.length;
        }
        return ps;
    }
    public static int[] previousSmaller(int A[]) {
         int ps[]= new int[A.length];
        Arrays.fill(ps,-1);
        Stack<Integer> stack = new Stack<>();
        for(int i=A.length-1;i>=0;i--) {
            if(stack.isEmpty() || A[stack.peek()]<A[i]) {
                stack.push(i);
            }
            else {
                while(!stack.isEmpty() && A[stack.peek()]>=A[i]) {
                    ps[stack.pop()] = i;
                }
                stack.push(i);
            }
        }
        return ps;
    }
}
