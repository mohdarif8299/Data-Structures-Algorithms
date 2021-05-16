public class Solution {
    public int solve(String A, String B) {
        int ans=0;
        B = B+B;
        B = B.substring(0,B.length()-1);
        System.out.println(B);
        String S = A+"$"+B;
        int Z[] = getZArray(S);
        for(int i=1;i<Z.length;i++) {
            if(A.length()==Z[i]) ans+=1;
        }
        return ans;
    }
    private static int[] getZArray(String str) {
        int n = str.length();
        int Z[] = new int[n]; 
        int L = 0, R = 0;
        for(int i = 1; i < n; ++i) {
            if(i > R){
                L = R = i;
                while(R < n && str.charAt(R - L) == str.charAt(R))
                    R++;
                Z[i] = R - L;
                R--;
            }
            else{
                int k = i - L;
                if(Z[k] < R - i + 1)
                    Z[i] = Z[k];
                else{
                    L = i;
                    while(R < n && str.charAt(R - L) == str.charAt(R))
                        R++;
                    Z[i] = R - L;
                    R--;
                }
            }
        }
        return Z;
    }
}
