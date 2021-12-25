class Solution {
    public int lengthOfLongestSubstring(String s) {
        if(s.length() <= 1) return s.length();
        int p1 = 0, p2 = 1;
        Set<Character> set = new HashSet<>();
        set.add(s.charAt(p1));
        int maxLen = 1;
        while(p1 < s.length() && p2 < s.length()) {
            if(set.contains(s.charAt(p2))) {
                set.remove(s.charAt(p1));
                p1++;
                
            } else {
                set.add(s.charAt(p2));
                p2++;
            }
            maxLen = Math.max(maxLen, Math.abs(p2-p1));
        }
        return maxLen;
    }
}