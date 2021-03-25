import java.util.*;
public class AthPerfectNumber {
    public static void main(String[] args) {
        int A = 4;
        System.out.println(solve(A));
    }
    public static String solve(int A) {
        String ans = "";
        Queue<String> queue = new LinkedList<>();
        queue.add(1+"");queue.add(2+"");
        if(A==1) return "11";
        else if(A==2) return "22";
        int count = 2,i=2;
        while(i<A) {
            i++;
            String sb = queue.poll();
            queue.add(sb+"1");
            count++;
            if(count==A) {
                ans = sb+"1";
                break;
            }
            queue.add(sb+"2");
            count++;
            
            if(count==A)  {
                ans = sb+"2";
                break;
            }
           
        }
        return ans+new StringBuilder(ans).reverse().toString();
    }
}