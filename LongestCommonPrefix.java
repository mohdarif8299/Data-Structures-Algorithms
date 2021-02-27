public class LongestCommonPrefix {
    public static void main(String[] args) {
        String S[] = {"abcd","abcds","adfg"};
        System.out.println(solve(S));
    }
    public static String solve(String S[]) {
        if(S.length==0) return "";
        if(S.length==1) return S[0];
        String longestCommonPrefix = "",S1="",S2="";
        int max = Integer.MAX_VALUE;
        for(int i=0;i<S.length;i++) {
            if(max>S[i].length()) {
                S1 = S[i];
                max = S[i].length();
            }
        }
        for(int i=0;i<S1.length();i++) {
            for(int j=0;j<S.length;j++) {
                if(S1.charAt(i)==S[j].charAt(i)) continue;
                return longestCommonPrefix;
            }
            longestCommonPrefix+=S1.charAt(i);
        }
        return longestCommonPrefix;
    }
}