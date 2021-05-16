public class Solution {
    public int solve(String A, int B) {
        int flip[] = new int[A.length()];
        int status=0;
        int bit=0;
        int ans=0;
        int N = A.length();
        int i=0;
        for( i=0;i<=N-B;i++) {
            status = status^flip[i];
            bit = A.charAt(i)-'0';
            if((status^bit)==0) {
                flip[i]=1;
                if(i+B<N) {
                    flip[i+B]=1;
                }
                ans+=1;
                status = status^1;
            }
        }
        while(i<N) {
             status = status^flip[i];
            bit = A.charAt(i)-'0';
            if((status^bit)==0) return -1;
            i+=1;
        }
        return ans;
    }
}
