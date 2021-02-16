public class InversionCount {
    public static void main(String[] args) {
        int A[] = {3,1,4,5,2,10};
        System.out.println(solve(A));
    }
    public static int solve(int A[]) {
        return (int)(divide(A,0,A.length-1)%1000000007);
    }
    public static long divide(int A[],int start,int end) {
        if(start==end) return 0;
        int mid = (start+end)/2;
        long c1 = divide(A,start,mid);
        long c2 = divide(A,mid+1,end);
        long pairs = crossPairs(A,start,mid,end);
        return c1+c2+pairs;
    }
    public static long crossPairs(int A[],int start,int mid,int end) {
        
        long crossPair=0;
        int temp[] = new int[mid-start+1];
        int temp2[] = new int[end-mid];
        int p1=0,p2=0;
        // Initializing arrays
        for(int i=0;i<temp.length;i++) {
            temp[i] = A[start+i];
        } 
        for(int i=0;i<temp2.length;i++) {
            temp2[i] = A[mid+1+i];
        } 
        // couting pairs
        while(p1<temp.length && p2<temp2.length) {
            if(temp[p1]>temp2[p2]) {
                crossPair+=((temp.length-p1));
                p2++;
            }
            else p1++;
        }
        // Merging Sorted Arrays
        int pointer1=0,pointer2=0,k=start;
        while(pointer1<temp.length && pointer2<temp2.length) {
            if(temp[pointer1]<temp2[pointer2]) {
                A[k++] = temp[pointer1++];
            }
            else A[k++] = temp2[pointer2++];
        }

        while(pointer1<temp.length) {
            A[k++] = temp[pointer1++];
        }
        while(pointer2<temp2.length) {
            A[k++] = temp2[pointer2++];
        }
        return (int)crossPair;
    }
}