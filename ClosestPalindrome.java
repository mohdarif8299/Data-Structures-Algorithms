public class ClosestPalindrome {
    public static void main(String[] args) {
        String A = "aaaaaaa";
        System.out.println(solve(A));
    }
    public static String solve(String S) {
        int i=0,j=S.length()-1;
        int count=0;
        while(i<=j) {
            if(S.charAt(i)!=S.charAt(j)) {
                count+=1;
            }
            if(count==2) return "NO";
            i++;
            j--;
        }
        if(S.length()%2==0 && count==0) return "NO";
        return "YES";
    }
}