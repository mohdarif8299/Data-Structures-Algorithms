class Solution {
    public boolean checkInclusion(String s1, String s2) {
        
        if(s1.length() > s2.length()) return false;
        
        int window[] = new int[26];
        int window2[] = new int[26];
        for(int i=0;i<s1.length();i++)
            window[s1.charAt(i)-'a']++;
        for(int i=0;i<s1.length();i++)
            window2[s2.charAt(i)-'a']++;
        
        if(Arrays.equals(window, window2)) return true;
        
        for(int i=s1.length();i<s2.length();i++) {
            window2[s2.charAt(i)-'a']++;
            window2[s2.charAt(i-s1.length())-'a']--;
            
            if(Arrays.equals(window, window2)) return true;
        }
        return false;
    }
}