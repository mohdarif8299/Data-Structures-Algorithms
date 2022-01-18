class Solution {
    public class Pair {
        int index;
        char ch;
        Pair(char ch, int index) {
            this.ch = ch;
            this.index = index;
        }
    }
    public int firstUniqChar(String s) {
        Queue<Pair> queue = new LinkedList<>();
        int ch[] = new int[26];
        
        for(int i=0;i<s.length();i++) {
            char c = s.charAt(i);
            ch[c - 'a']++;
            if(ch[c - 'a'] == 1) {
                queue.add(new Pair(c, i));
            } else {
                while(!queue.isEmpty() && ch[queue.peek().ch - 'a']!=1) 
                    queue.poll();
            }
        }
        if(queue.isEmpty()) return -1;
        return queue.peek().index;
    }
}