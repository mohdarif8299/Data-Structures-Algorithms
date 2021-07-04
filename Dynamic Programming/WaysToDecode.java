public class Solution {
    public int numDecodings(String A) {
       long dp[] = new long[A.length()+1];
       Arrays.fill(dp,-1);
       return (int)(ways(0,A,dp)%1000000007);
    }
    public static long ways(int i,String s,long[] dp) {
       if(i>s.length()) return 0;
       if(i==s.length()) return 1;
       if(s.charAt(i)-'0'==0) return 0;
       if(dp[i]!=-1) return dp[i];
       long x=0,y=0; 
       x=ways(i+1,s,dp);
       if(i+1<s.length() && (s.charAt(i)-'0')*10+(s.charAt(i+1)-'0')<=26) {
           y=ways(i+2,s,dp);
       }
       dp[i] = ((x+y)%1000000007);
       return dp[i];
    }
}
