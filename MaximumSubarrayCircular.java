class Solution
{
    long maxFruits(long arr[] ,int n,int m) {
        long max = 0;
        for(int i=0;i<m;i++) {
            max+=arr[i];
        }
        long window = max;
        for(int i=m;i<n+m;i++) {
            window+=arr[i%n]-arr[(i-m)%n];
            max = Math.max(max,window);
        }
        return max;
    }
}
