public class CountPairWithSum {
    public static void main(String[] args) {
        int A[] = {5, 10, 20, 100, 105};
        int B=110;
        System.out.println(solve(A,B));
    }
    public static int solve(int A[],int B) {
        int p1=0,p2=A.length-1;
        int count=0;
        while(p1<p2) {
            if(A[p1]+A[p2]==B) {
                count++;
                p1++;p2--;
            }
            else if(A[p1]+A[p2]<B) {
                p1++;
            }
            else p2--;
        }
        return count;
    }
}