import java.util.*;
public class AmazingSubarray {
    public static void main(String[] args) {
        String S = "abec";
        System.out.println(solve(S));
    }
    public static int solve(String S) {
        Character[] ch = {'a','e','i','o','u','A','E','I','O','U'};
        Set<Character> set = new HashSet<>(Arrays.asList(ch));

        int count=0;
        int N = S.length();
        for(int i=0;i<S.length();i++) {
            if(set.contains(S.charAt(i))) {
                count+=(N-i);
            }
        }
        return count%10003;
    }
}