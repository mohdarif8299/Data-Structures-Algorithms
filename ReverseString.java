import java.util.*;
public class ReverseString {
    public static void main(String[] args) {
        String S =  "the sky is blue";
        System.out.println(solve(S));
    }
    public static String solve(String S) {
        String ans = "";
        ArrayList<String> aList = new ArrayList<>();
        int i=0,j=1;
        if(S.charAt(i)!=' ' && S.charAt(j)==' ') { aList.add(S.substring(i,j)); i++;j++; }
        while(i<S.length() && S.charAt(i)==' ') i++;
        while(j<S.length() && S.charAt(j)==' ') j++;
        if(i==j) j++;
        while(i<=j && j<S.length()) {
            while(j<S.length() && S.charAt(j)!=' ') {
                j++;
            }
            aList.add(S.substring(i,j));
            while(j<S.length() && S.charAt(j)==' ') j++;
            i=j;
            j+=1;
        }
        if(i<S.length() && S.charAt(i)!=' ' && j==S.length()) aList.add(S.charAt(i)+"");
        System.out.println(aList);
        for(int k=aList.size()-1;k>0;k--) {
            ans+=aList.get(k)+" ";
        }
        ans+=aList.get(0);
        return ans;
    }
 }