public class Solution {
    public int solve(String A) {
        StringBuilder sb = new StringBuilder(A);
        String S = A+"#"+sb.reverse().toString();
        int Z[] = getZArray(S);
        int max = 0;
        int n = S.length();
        //System.out.println(Arrays.toString(Z));
        for(int i=n-1;i>=0;i--) { 
            if(n-i==Z[i]) {
                max = Math.max(max,Z[i]); 
            }
            
        }
        
       // System.out.println(max);
        return A.length()-max;
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
