public class WaterTrapped {
    public static void main(String[] args) {
        int A[] = {4,3,2,1,4};
        System.out.println(solve(A));
    }
    public static int solve(int A[]) {
        int maximum_water_trapped = Integer.MIN_VALUE;
        int P1 = 0,P2=A.length-1;
        while(P1<P2) {
            int ans = (P2-P1)*Math.min(A[P1],A[P2]);
            maximum_water_trapped = Math.max(maximum_water_trapped,ans);
            if(A[P1]<A[P2]) P1++; else P2--;
        }
        return maximum_water_trapped;
    }
}