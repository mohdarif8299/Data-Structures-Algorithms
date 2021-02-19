import java.util.*;
public class StringQuestion {
    public static void main(String[] args) {
        System.out.println(solve("Rahul","Sharma"));
    }
    public static int solve(String S1,String S2) {
        S1 = S1.toLowerCase();
        S2 = S2.toLowerCase();
        String s1 = S1;
        String s2 = S2;
        int count=0;
        for(int i=0;i<S1.length() && i<S2.length();i++) {
            if(S1.charAt(i)==S2.charAt(i)) {
                s1 = s1.replace(S1.charAt(i)+"","");
                s2 = s2.replace(S2.charAt(i)+"","");
                count+=2;
            }
        }
        if(s1.equals(s2)) return count;
        else {
            int []freq1 = new int[26]; 
                int []freq2 = new int[26]; 
                Arrays.fill(freq1, 0); 
                Arrays.fill(freq2, 0); 
                int i; 
                for (i = 0; i < s1.length(); i++) 
                    freq1[s1.charAt(i) - 'a']++; 
                for (i = 0; i < s2.length(); i++) 
                    freq2[s2.charAt(i) - 'a']++; 
                for (i = 0; i < 26; i++) 
                    count += (Math.min(freq1[i], freq2[i])); 
        
                }
        return count;
    }
}