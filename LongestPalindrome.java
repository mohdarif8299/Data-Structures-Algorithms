public class LongestPalindrome {
    public static void main(String[] args) {
        String S = "bababaabababbaabababa";
        System.out.println(solve(S));
    }
    public static String solve(String S) {
        int length = Integer.MIN_VALUE;
        String A = "";
        for(int i=1;i<S.length();i++) {
            int p1 = i-1;
            int p2 = i+1;
          
            while(p1>=0 && p2<S.length() && S.charAt(p1)==S.charAt(p2)) {
                
                if(p2-p1+1>length) {
                    length = p2-p1+1;
                    A = S.substring(p1,p2+1);
                }
                p1--;
                p2++;
            }

            p1=i-1;
            p2=i;

            while(p1>=0 && p2<S.length() && S.charAt(p1)==S.charAt(p2)) {
                if(p2-p1+1>length) {
                    length = p2-p1+1;
                    A = S.substring(p1,p2+1);
                }
                p1--;
                p2++;
            }
        }
        if(A.length()==0) return S.charAt(0)+"";
        return A;
    }
}