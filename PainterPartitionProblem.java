public class PainterPartitionProblem {
    public static void main(String[] args) {
        int A[] = {1000000,1000000 };
        int p=1,B=1000000;
        System.out.println(solve(A,p,B));
    }
    public static int solve(int A[],int p,int B) {
        int sum = 0;
        sum = A[0];
        int max  =A[0];
        for(int i=1;i<A.length;i++) {
            sum+=A[i];
            if(max<A[i]) max = A[i];
        }
        if(p==A.length) return (int)(1L*max*B%10000003);
        int minimumTime = binarySearch(A,(1L*max*B),(1L*sum*B),p,B);
        return minimumTime;

    }
    public static int binarySearch(int A[],long low,long high,int p,int B) {
        long ans=low;
        while(low<=high) {
            long mid = (low+high)/2;
            if(check(A,mid,p,B)) {
                ans = mid; 
                high = mid-1;
            }
            else low=mid+1; 
        }
        return (int)(ans%10000003);
    }
    public static boolean check(int A[],long time,int p,int B) {
        int painter=1;
        long painterTotalPaint = 0;
        for(int i=0;i<A.length;i++) {
            painterTotalPaint+=1L*A[i]*B;    
            if(painterTotalPaint>time) {
                  painter++;
                  painterTotalPaint=1L*A[i]*B;
            }  
        }
        return (painter<=p)?true:false;
    }
}