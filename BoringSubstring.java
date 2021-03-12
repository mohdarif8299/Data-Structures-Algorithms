import java.util.*;
public class BoringSubstring {
    public static void main(String[] args) {
        String A = "abcdbc";
        System.out.println(solve(A));
    }
    public static int solve(String A) {
        String evenLength="",oddLength="";
        char[] ch = A.toCharArray();
        Arrays.sort(ch);
        for(int i=0;i<ch.length;i++) {
            if(ch[i]%2==0) {
                evenLength+=ch[i];
            }
            else {
                oddLength+=ch[i];
            }
        }
        if(Math.abs(oddLength.charAt(0)-evenLength.charAt(evenLength.length()-1))!=1) return 1;
        else if(Math.abs(oddLength.charAt(oddLength.length()-1)-evenLength.charAt(0))!=1) return 1;
        return 0;
    }
}