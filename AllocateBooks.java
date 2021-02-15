public class AllocateBooks {
    public static void main(String[] args) {
        int A[] = {12,34,67,90};
        int B = 5;
        System.out.println(solve(A,B));
    }
    public static int solve(int A[],int B) {
        if(B>A.length) return -1;
        int max= A[0];
        long sum=A[0];
        for(int i=1;i<A.length;i++) {
            sum+=A[i];
            if(max<A[i]) max = A[i]; 
        }
        return binarySearch(A,max,sum,B);
    }
    public static boolean checkAllocation(int A[],long mid,int B){
        int student=1;
        long allocatedBook=0;
        for(int i=0;i<A.length;i++) {
            allocatedBook+=A[i];
            if(allocatedBook>mid) {
                allocatedBook = A[i];
                student++;
            }
        }
        return (student<=B)?true:false;
    }
    public static int binarySearch(int A[],long max,long sum,int B) {
        long low = max;
        long high = sum;
        long ans = low;
        while(low<high) {
            long mid =(low+high)/2;
            if(checkAllocation(A,mid,B)) {
                ans = mid;
                high = mid-1;
            }
            else low = mid+1;
        } 
        return (int)ans;
    }
}