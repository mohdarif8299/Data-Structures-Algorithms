class Solution {
    public int countPrimes(int n) {
        if(n < 2) return 0;
        int arr[] = seive(n);
        return arr[n-1];
    }
    public static int[] seive(int n) {
        int arr[] = new int[n+1];
        Arrays.fill(arr,1);
        arr[0] = 0;
        arr[1] = 0;
        for(int i=2;i*i<=n;i++) {
            if(arr[i]==1) {
                for(int j=i*i;j<=n;j+=i) {
                    arr[j] = 0;
                }
            }
        }
        for(int i=3;i<=n;i++)
            arr[i] += arr[i-1];
        return arr;
    }
}