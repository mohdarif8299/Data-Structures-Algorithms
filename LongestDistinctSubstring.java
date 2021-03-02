import java.util.*;
public class LongestDistinctSubstring {
    public static void main(String[] args) {
        String S = "AaaB";
        System.out.println(solve(S));
    }
    public static int solve(String S) {
        Set<Character> set = new HashSet<>();
        int i=0,j=1;
        int max = 0;
        set.add(S.charAt(i));
        while(j<S.length() && i<S.length()) {
            if(!set.contains(S.charAt(j))) {
                set.add(S.charAt(j));
                j++;
            } else {
                set.remove(S.charAt(i));
                i+=1;
            }
            max = Math.max(max,Math.abs(j-i));
        }
        return max;
    }
}