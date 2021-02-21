public class RectanglesCount {
    public static void main(String[] args) {
        int A[] = {1,2,3,4,5 };
        int B =5;
        System.out.println(solve(A,B));
    }
    public static int solve(int A[],int B) {
        long count=0;
        int i=0,j=A.length-1;
        while(i<=j) {
            if(1L*A[i]*A[j]<B) {
                count = (count+2*(j-i)+1);
                i++;
            }
            else j--;
        }
        
        return (int)(count%1000000007);
    }
}