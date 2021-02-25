import java.util.*;
public class ColorfulNumber {
    public static void main(String[] args) {
        int A = 236;
        System.out.println(solve(A));
    }
    public static int solve(int A) {
        ArrayList<Long> Al = new ArrayList<>();
        int N = A;
        while(N>0) {
            Al.add(1L*N%10);
            N = N/10;
        } 
        Collections.reverse(Al);
        ArrayList<Long> list = new ArrayList<>();
        list.add(Al.get(0));
        for(int i=1;i<Al.size();i++) { 
            if(list.get(i-1)*Al.get(i)==Al.get(i) || list.get(i-1)==Al.get(i)) return 0;
            list.add(list.get(i-1)*Al.get(i));
        }
        Set<Long> set = new HashSet<>();
        for(int i=0;i<Al.size();i++) {
            if(set.contains(Al.get(i))) return 0;
            set.add(Al.get(i));
        }
        set.clear();
        for(int i=0;i<list.size();i++) {
            if(set.contains(list.get(i))) return 0;
            set.add(list.get(i));
        }
        return 1;
    }
}