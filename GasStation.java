public class GasStation {
    public static void main(String[] args) {
        int A[] = {2,3,4};
        int B[] = {3,4,3};
        System.out.println(solve(A,B));
    }
    public static int solve(int A[],int B[]) {
       int X = 0,index=0,total=0;
       for(int i=0;i<A.length;i++) {
           X = X+A[i]-B[i];
           if(X<0) {
               index = i+1;
               total = total+X;
               X = 0;

           }
       }
       if(total+X<0) return -1;
       return index;
    }
}