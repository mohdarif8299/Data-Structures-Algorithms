public class RomanToInteger { 
    public static void main(String[] args) {
        int X = 1994;
        System.out.println(solve(X));
    }
    public static String solve(int X) {
       int A[] = {1000,900,500,400,100,90,50,40,10,9,5,4,1};
       String B[] = {"M","CM","D","CD","C","XC","L","XL","X","IX","V","IV","I"};
       String ans = "";
       for(int i=0;i<A.length;i++) {
           while(X>=A[i]) {
               ans+=B[i];
               X-=A[i];
           }
       }
       return ans;
    }
}