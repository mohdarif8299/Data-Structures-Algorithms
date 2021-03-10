import java.util.*;
public class PeriodicString {
    public static void main(String[] args) {
        String A = "umealnlfdumealnlfdumealnlfdmmm";
        System.out.println(solve(A));
    }
    public static int solve(String A) {
        Map<Character,Integer> map = new TreeMap<>();
        for(int i=0;i<A.length();i++) {
            if(map.containsKey(A.charAt(i)))
            map.put(A.charAt(i),map.get(A.charAt(i))+1); 
            else map.put(A.charAt(i),1);
        }
        int minimum = Integer.MAX_VALUE;
        ArrayList<Integer> aList = new ArrayList<>(map.values());
        for(Integer i:aList) {
            minimum = Math.min(minimum,i);
        }
        int period = 0;
        for(Integer i:aList) {
            period+=(i/minimum);
        }
        return period;
    }
}