import java.util.*;
public class ZAlgorithm {
    public static void main(String[] args) {
        String pattern = "a";
        String text = "aaaaaaa";
        System.out.println(solve(text,pattern));
    }
    public static int solve(String text,String pattern) {
        String S = pattern+"#"+text;
        int Z[] = new int[S.length()-1];
        for(int i=1;i<Z.length;i++) {
            int p=0;
            int p1 = i+1;
            int count=0;
            while(p1<S.length() && S.charAt(p)==S.charAt(p1)) {
                count++;
                p++;
                p1++;
            }
            Z[i] = count;
        }
        int occurrences = 0;
        for(int i=1;i<Z.length;i++) {
            if(Z[i]==pattern.length()) occurrences++;
        }
        return occurrences;
    }
}