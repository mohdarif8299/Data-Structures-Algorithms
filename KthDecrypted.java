import java.util.*;
public class KthDecrypted {
    public static void main(String[] args) {
        String S = "ab2c3";
        int B = 14;
        System.out.println(solve(S,B));
    }
    public static String solve(String A,int B) {
        Stack<Pair> stack = new Stack<>();
        long count = 0;
        long K = 1L*B;
        char c = ' ';
        for(int i=0;i<A.length();i++) {
            char ch = A.charAt(i);
            if(ch >='a' && ch<='z') {
                count+=1;
                Map<Character,Long> map = new HashMap<>();
                Pair p = new Pair(ch,count);
                stack.push(p);
            }
            else {
                StringBuilder sb = new StringBuilder("");
                int k = i;
                while(k<A.length() && (A.charAt(k)>='0' && A.charAt(k)<='9')) {
                    sb.append(A.charAt(k)+"");
                    k++;
                }
                count*=Integer.parseInt(sb+"");
            }
            if(B==count) return A.charAt(i-1)+"";
        }
           while(K>0) {
               Pair p = stack.pop();
               K=K%p.l;
               c=p.ch;
           }
        return c+"";
    }
}
class Pair {
    public Character ch;
    public Long l;
    Pair(Character ch,Long l) {
        this.ch = ch;
        this.l = l;
    }
    public String toString() {
        return ch+" "+l;
    }

}
