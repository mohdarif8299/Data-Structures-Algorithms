class Solution {
    public List<Integer> findAnagrams(String s, String p) {
        List<Integer> list = new ArrayList<>();
        int ch[] = new int[26];
        int word[] = new int[26];
        for(int i=0;i<p.length();i++) ch[p.charAt(i) - 'a']++;
    
        for(int i=0;i<p.length() && i < s.length();i++) {
            word[s.charAt(i) - 'a']++;
        }
        
        if(isEqual(ch, word)) list.add(0);
        
        for(int i=1;i<=s.length()-p.length();i++) {
            word[s.charAt(i-1)-'a']--;
            word[s.charAt(i+(p.length()-1)) - 'a' ]++;
            if(isEqual(ch, word)) list.add(i);
        }
        return list;
        
    }
    public boolean isEqual(int ch[], int word[]) {
        for(int i=0;i<ch.length;i++) {
            if(ch[i] != word[i])  return false;
        }
        return true;
    }
}