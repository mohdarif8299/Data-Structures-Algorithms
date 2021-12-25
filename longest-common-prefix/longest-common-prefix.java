class Solution {
    public String longestCommonPrefix(String[] strs) {
         String smallest = strs[0];
         String prefix = "";
        for(String s: strs) {
            if(smallest.length() > s.length()) 
                smallest = s;
        }
        for(int i=0;i<smallest.length();i++) {
            for(String s: strs) {
                if(smallest.charAt(i) == s.charAt(i)) continue;
                return prefix;
            }
            prefix += smallest.charAt(i);
        }
        return prefix;
    }
}