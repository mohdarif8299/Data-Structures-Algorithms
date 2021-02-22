import java.util.*;
public class HotelVisit {
    public static void main(String[] args) {
        int A[] = {1,2,3,4};
        System.out.println(solve(A));
    }
    public static ArrayList<Integer> solve(int A[]) {
        Map<Integer,Integer> map = new HashMap<>();
        for(int i=0;i<A.length;i++) {
           map.put(A[i],i);
        }
        ArrayList<Map.Entry<Integer,Integer>> AL = new ArrayList<>(map.entrySet());
        Collections.sort(AL,(i1,i2)->i1.getValue().compareTo(i2.getValue()));
        ArrayList<Integer> list = new ArrayList<>();
        for(Map.Entry<Integer,Integer> entry:AL) {
            list.add(entry.getKey());
        } 
        return list;
    }
}