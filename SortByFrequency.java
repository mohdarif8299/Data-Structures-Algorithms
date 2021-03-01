import java.util.*;
public class SortByFrequency {
    public static void main(String[] args) {
        String S = "tree";
        System.out.println(solve(S));
    }
    public static String solve(String S) {
        String s="";
        char[] ch = S.toCharArray();
        Map<Character,Integer> map = new HashMap<>();
        for(int i=0;i<ch.length;i++) {
            if(map.containsKey(ch[i]))
            map.put(ch[i],map.get(ch[i])+1);
            else map.put(ch[i],1);
        }
        List<Map.Entry<Character,Integer>> a = new ArrayList<>(map.entrySet());
        Collections.sort(a,(m1,m2)-> m2.getValue().compareTo(m1.getValue()));
        for(Map.Entry<Character,Integer> entry:a) {
            for(int i=0;i<entry.getValue();i++) {
                s+=entry.getKey();
            }
        }
        return s;
    }
}