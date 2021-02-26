import java.util.*;
public class LongestDistinctSubstring {
    public static void main(String[] args) {
        String S = "dadbc";
        System.out.println(solve(S));
    }
    public static int solve(String S) {
        Set<Character> set = new HashSet<>();
        int countLength=1;
        int i=0,j=1;
        int max = 1;
        set.add(S.charAt(i));
        while(i<j && j<S.length()) {
            if(S.charAt(i)!=S.charAt(j) && !set.contains(S.charAt(j))) {
                countLength+=1;
                set.add(S.charAt(j));
                j++;
            } else {
                countLength = 1;
                set.remove(S.charAt(i));
                i+=1;
            }
            max = Math.max(max,countLength);
        }
        System.out.println(set);
        return max;
    }
}