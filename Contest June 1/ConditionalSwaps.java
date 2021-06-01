public class Solution {
    public String solve(int A, int[] B, String C) {
        int S[] = new int[A];
        ArrayList<Integer> index = new ArrayList<>();
        for(int i=0;i<A;i++) {
            S[i] = B[i];
        }
        Arrays.sort(S);
        HashMap<Integer,Character> map = new HashMap<>();
        for(int i=0;i<C.length();i++) {
            map.put(i,C.charAt(i));
        }
        for(int i=0;i<A;i++) {
            if(S[i]!=B[i]){
                index.add(i);
            }
        }
        //System.out.println(index);
        if(index.size()==2) {
            if( index.get(0)==A-1 && map.get(index.get(0))=='1') return "YES";
            return "NO";
        } 
        for(int i=0;i<index.size()-1;i++) {
            if(map.get(index.get(i))!='1') return "NO";
        }
        return "YES";
    }
}
