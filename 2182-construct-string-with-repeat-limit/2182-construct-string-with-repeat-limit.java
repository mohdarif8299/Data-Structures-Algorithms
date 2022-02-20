class Solution {
    class Pair {
        int key;
        int value;
        Pair(int key, int value) {
            this.key = key;
            this.value = value;
        }
    }
    public String repeatLimitedString(String s, int repeatLimit) {
        int ch[] = new int[26];
        for(int i=0;i<s.length();i++) ch[s.charAt(i) - 'a']++;
        PriorityQueue<Pair> pq = new PriorityQueue<>((a,b) -> b.key - a.key);
        
        for(int i=0;i<26;i++) 
            if(ch[i] > 0)
                pq.add(new Pair(i, ch[i]));
        
        
        StringBuilder sb = new StringBuilder("");
        while(!pq.isEmpty()) {
            int chars = pq.peek().key;
            int freq = pq.peek().value;
            pq.poll();
            
            if(sb.length() == 0 || sb.charAt(sb.length()-1) != (chars + 'a')) {
                
                int times = Math.min(freq, repeatLimit) ;
                
                for(int i=0;i<times;i++) {
                    sb.append((char)(chars + 'a'));
                }
                
                freq = freq - times;
                
                if(freq > 0) 
                    pq.add(new Pair(chars, freq));
                
            } else {
                if(pq.size() == 0) break;
                int char1 = pq.peek().key;
                int freq1 = pq.peek().value;
                pq.poll();
                
                sb.append((char)(char1 + 'a'));

                freq1 -= 1;
                
                if(freq1 > 0) {
                    pq.add(new Pair(char1, freq1));
                }
                
                pq.add(new Pair(chars, freq));
                
            }
        }
        return sb.toString();
    }
}