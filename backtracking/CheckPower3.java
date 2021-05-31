class Solution {
    public boolean checkPowersOfThree(int K) {
        int N = 19;
        int presum[] = new int[N];
        presum[0]=1;
        for(int i=1;i<N;i++) presum[i] = 3*presum[i-1];
        return checkPower(0,N,presum,K);
    }
    public static boolean checkPower(int i,int N,int A[],int K) {
        if(K==0) return true;
        if(i==N || K<0) return K==0;
        return ( checkPower(i+1,N,A,K) || checkPower(i+1,N,A,K-A[i]));
    }
}
