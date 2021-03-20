import java.util.*;
public class NonRepeating {
    public static void main(String[] args) {
        String A = "dabcaabde";
        System.out.println(solve(A));
    }
    public static String solve(String A) {
        StringBuilder sb = new StringBuilder("");
        Queue<Character> queue = new LinkedList<>();
        Character ch[]  = new Character[A.length()];
        int FR[] = new int[26];
        for(int i=0;i<A.length();i++) {
            FR[A.charAt(i)-'a']++;
            if(FR[A.charAt(i)-'a']==1) {
                queue.add(A.charAt(i));
            }
            else  {
                
                while(!queue.isEmpty() && FR[queue.peek()-'a']!=1) {
                    queue.poll();
                }
            }
            if(queue.peek()==null) 
            sb.append('#');
            else sb.append(queue.peek());
        } 
        return sb.toString();
    }
}