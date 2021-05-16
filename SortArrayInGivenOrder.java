public class Solution {
    public ArrayList<Integer> solve(ArrayList<Integer> A, ArrayList<Integer> B) {
     Map<Integer,Integer> map = new TreeMap<>();
         for(Integer i:A) {
             if(map.containsKey(i)) {
                 map.put(i,map.get(i)+1);
             } else {
                 map.put(i,1);
             }
         }
         A.clear();
         for(Integer X:B) {
             if(map.containsKey(X)) {
                 int count = map.get(X);
                 while(count>0) {
                     A.add(X);
                     count-=1;
                 }
                 map.remove(X);
             }
         }
         Set<Integer> key = map.keySet();
         for(Integer i:key) {
              int count = map.get(i);
                 while(count>0) {
                     A.add(i);
                     count-=1;
                 }
         }
         return A;
    }
}
