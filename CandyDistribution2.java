public class Solution {
   
    public int candy(int[] A) {
      int left[] = new int[A.length];
      int right[] = new int[A.length];
      Arrays.fill(left,1);
      Arrays.fill(right,1);
      int ans=0;
      left[0]=1;
      for(int i=1;i<A.length;i++) if(A[i]>A[i-1]) left[i]=left[i-1]+1;
      right[A.length-1]=1;
      for(int i=A.length-2;i>=0;i--) if(A[i]>A[i+1]) right[i]=right[i+1]+1;
      for(int i=0;i<A.length;i++) ans+=Math.max(left[i],right[i]);
      return ans;
    }
}
