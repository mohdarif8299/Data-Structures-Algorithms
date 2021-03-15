public class LongestCommonPrefixII {
    public static void main(String[] args) {
        String[] S  = {"abcdc","abcdf","abcfd","abdce","abdbc","abdcb","abdab"};
        int B = 3;
        System.out.println(solve(S,B));
    }
    public static int solve(String[] S,int B) {
        String str = "";
        long count=0;
        int i=0,j=1;
        while(j<S.length) {
            if(check(S[i],S[j],B)) {
                j++;
                if(j==S.length) {
                  count+= (j-i)*(j-i+1)/2;
                }
            }
            else {
                count+=((j-1)-i+1);
                i++;
            }

        }
        return (int)(count%1000000007);
    }
    public static boolean check(String STR,String A,int B) {
        if(STR.length()>=B && A.length()>=B) {
            for(int i=0;i<B;i++) {
            if(STR.charAt(i)==A.charAt(i)) continue;
            else return false;
            }
            return true;
        }
        return false;
    }
}