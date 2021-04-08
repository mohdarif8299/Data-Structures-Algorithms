public class Solution {
    public int solve(int[] A, int B) {
        int f[] = new int[1000001];
           int max = Integer.MIN_VALUE,min = Integer.MAX_VALUE;
           for(int i=0;i<A.length;i++) {
               max = Math.max(max,A[i]);
               min = Math.min(min,A[i]);
               f[A[i]]++;
           }
           while(min<max && B!=0) {
              if(f[min]>=f[max]) {
                   if(B<f[max]) break;
                   f[max-1]=f[max-1]+f[max];
                   B = B-f[max];
                   max-=1;
               }
               else {
                   if(B<f[min]) break;
                   f[min+1]+=f[min];
                   B = B-f[min];
                   min+=1;
               }
           }
           return max-min;
    }
}
