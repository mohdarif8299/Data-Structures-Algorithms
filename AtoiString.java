import java.util.*;
public class AtoiString {
    public static void main(String[] args) {
        String S = "+ -7  bfbn";
        System.out.println(solve(S));
    }
    public static int solve(String S) {
        Character[] ch = {'0','1','2','3','4','5','6','7','8','9'};
        Set<Character> set = new HashSet<>(Arrays.asList(ch));
        String number= "";
        int i=0;
        boolean isNegative = false;
        boolean isPositive = false;
        while(i<S.length()) {
            if(number.length()==0  && S.charAt(i)!='-' && S.charAt(i)!='+'  && !set.contains(S.charAt(i))) return 0;
            if(i>0 && S.charAt(i-1)=='-') {
                if(isPositive) return 0;
                if(isNegative) return 0;
                isNegative = true;
            }
            if(i>0 && S.charAt(i-1)=='+') {
                if(isNegative) return 0;
                if(isPositive) return 0;
                isPositive = true;
            }
            if(set.contains(S.charAt(i))) {
                number+=""+(int)(S.charAt(i)-'0');
            }
            else if(number.length()>0 && !set.contains(S.charAt(i))) {
                break;
            }
            i++;
        }
        long num = 0;
        for(i=0;i<number.length();i++) {
            num = num*10+(number.charAt(i)-48);
            if(num>=Integer.MAX_VALUE && !isNegative) return Integer.MAX_VALUE;
            if(-num<=Integer.MIN_VALUE ) return Integer.MIN_VALUE;
        }
        if(isNegative ) return (int)-num;
        return (int)num;
    }
}