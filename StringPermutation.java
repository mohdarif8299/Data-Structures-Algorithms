import java.util.*;
public class StringPermutation {
    public static void main(String[] args) {
        String A = "aca";
        String B = "acaa";
        System.out.println(solve(A,B));
    }
    public static int solve(String A,String B) {
        int count = 0;
        int  map[] = new int[26];
        for(int i=0;i<A.length();i++) {
            map[A.charAt(i)-'a']++;
        }
        for(int i=0;i<=B.length()-A.length();i++) {
            int  map1[] = new int[26];
            for(int j=0;j<A.length();j++) {
                map1[B.charAt(i+j)-'a']++;
            }
            if(checkArray(map,map1)) count+=1;
        }
        return count;
    }
    public static boolean checkArray(int A[],int B[]) {
        for(int i=0;i<26;i++) {
            if(A[i]!=B[i]) return false;
        }
        return true;
    }
}