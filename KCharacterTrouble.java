public class Solution {
    public String solve(String A, int B) {
        if(B==1) {
            return "";
        }
        StringBuilder sb = new StringBuilder("");
        Stack<Pair> stack = new Stack<>();
        int count=0;
       // Map<Character,Integer> map = new HashMap<>();
        for(int i=0;i<A.length();i++) {
           if(stack.size()==0) {
               stack.push(new Pair(A.charAt(i),1));
               continue;
           }
           if(!stack.isEmpty() && stack.peek().ch==A.charAt(i)) {
               Pair p = stack.peek();
               stack.pop();
               p.i+=1;
               if(p.i==B) continue;
               else stack.push(p);
           }
           else {
               stack.push(new Pair(A.charAt(i),1));
           }
        }
        while(!stack.isEmpty()) {
            char c = stack.peek().ch;
            int i = stack.peek().i;
              while(i-->0) {
                 sb.append(c);
            }
             stack.pop();
        }
        return sb.reverse().toString();
    }
    class Pair {
        Character ch;
        Integer i;
        Pair(Character c,Integer i) {
            this.ch  =c;
            this.i = i;
        }
    }
}
