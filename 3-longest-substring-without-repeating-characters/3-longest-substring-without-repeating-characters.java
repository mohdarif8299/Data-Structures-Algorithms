class Solution {
    public int lengthOfLongestSubstring(String s) {
        if(s.length() == 0) return 0;
        int p1 = 0;
        int p2 = 1;
        Set<Character> set = new HashSet<>();
        set.add(s.charAt(p1));
        int ans = 1;
        
        while(p1 < s.length() && p2 < s.length()) {
            if(set.contains(s.charAt(p2))) {
                set.remove(s.charAt(p1));
                p1++;
            } else {
                set.add(s.charAt(p2));
                ans = Math.max(ans, Math.abs(p2-p1)+1);
                p2++;
                
            }
        }
        return ans;
    }
}