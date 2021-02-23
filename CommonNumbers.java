import java.util.*;
public class CommonNumbers {
    public static void main(String[] args) {
        Integer A[] = {2, 1, 4, 10};
        Integer B[] = {3, 6, 2, 10, 10};
        System.out.println(solve(new ArrayList<Integer>(Arrays.asList(A)),new ArrayList<Integer>(Arrays.asList(B))));
    }
    public static ArrayList<Integer> solve(ArrayList<Integer> A,ArrayList<Integer> B) {
        ArrayList<Integer> ANS = new ArrayList<>();
        Map<Integer,Integer> mapA = new HashMap<>();
        Map<Integer,Integer> mapB = new HashMap<>();
        for(Integer I:A) {
            if(mapA.containsKey(I)) mapA.put(I,mapA.get(I)+1); 
            else mapA.put(I,1);
        }
        for(Integer I:B) {
            if(mapB.containsKey(I)) 
             mapB.put(I,mapB.get(I)+1);  
            else mapB.put(I,1);
        }
        System.out.println(mapA+"   "+mapB);
        for(int i=0;i<A.size();i++) {
            if(mapA.containsKey(A.get(i)) && mapB.containsKey(A.get(i))) {
                int count = Math.min(mapA.get(A.get(i)),mapB.get(A.get(i)));
                while(count>0) {
                    mapA.put(A.get(i),0);
                    mapB.put(A.get(i),0);
                    ANS.add(A.get(i));
                    count--;
                }
            }
        }
        return ANS;
    }
}