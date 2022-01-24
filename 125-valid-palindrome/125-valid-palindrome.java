class Solution {
    public boolean isPalindrome(String s) {
        s = s.replaceAll("[^a-zA-Z0-9]","").toLowerCase();
        return isPal(s);
    }
    public boolean isPal(String s) {
        int p1 = 0, p2 = s.length()-1;
        while(p1<p2) {
            if(s.charAt(p1)!=s.charAt(p2)) return false;
            p1++;p2--;
        }
        return true;
    }
}