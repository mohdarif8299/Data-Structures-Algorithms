class Solution {
    public int largestRectangleArea(int[] heights) {
        int pS[] = previousSmaller(heights);
        int nS[] = nextSmaller(heights);
        
        long ans = Integer.MIN_VALUE;
        
        for(int i=0;i<heights.length;i++) {
            ans = Math.max(ans, heights[i] * (nS[i] - pS[i] - 1));
        }
        
        return (int)ans;
    }
    public int[] nextSmaller(int A[]) {
      Stack<Integer> stack = new Stack<>();
      int NS[] = new int[A.length];
      Arrays.fill(NS, A.length);
      
      for(int i=0;i<A.length;i++) {
          if(stack.isEmpty()) {
              stack.push(i);
          } else {
              while(!stack.isEmpty() && A[i] < A[stack.peek()]) {
                  NS[stack.pop()] = i;
              }
              stack.push(i);
          }
      }
        return NS;
    }
    public int[] previousSmaller(int A[]) {
      Stack<Integer> stack = new Stack<>();
      int NS[] = new int[A.length];
      Arrays.fill(NS, -1);
      
      for(int i=A.length-1;i>=0;i--) {
          if(stack.isEmpty()) {
              stack.push(i);
          } else {
              while(!stack.isEmpty() && A[i] < A[stack.peek()]) {
                  NS[stack.pop()] = i;
              }
              stack.push(i);
          }
      }
        return NS;
    }
}