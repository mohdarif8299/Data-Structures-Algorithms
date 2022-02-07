class Solution {
    public char findTheDifference(String s, String t) {
        if(s.length() == 0) return t.charAt(0);
        
        int ch1[] = new int[26];
        int ch2[] = new int[26];
        
        for(int i=0;i<s.length();i++) ch1[s.charAt(i) - 'a']++;
        for(int i=0;i<t.length();i++) ch2[t.charAt(i) - 'a']++;
     
        
        for(int i=0;i<26;i++) {
            if(ch1[i]!=ch2[i]) {
                return (char)(i + 97);
            }
        }
        return ' ';
    }
}