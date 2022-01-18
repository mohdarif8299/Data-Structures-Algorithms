class Solution {
    public boolean checkInclusion(String s1, String s2) {
        if(s1.length() > s2.length()) return false;
        
        char p[] = new char[256];
        char w[] = new char[256];
        
        for(int i=0;i<s1.length();i++) {
            p[s1.charAt(i)]++;
            w[s2.charAt(i)]++;
        }
        for(int i=s1.length();i<s2.length();i++) {
            if(checkString(p,w)) return true;
            w[s2.charAt(i)]++;
            w[s2.charAt(i-s1.length())]--;
        }
        if (checkString(p,w)) return true;
        return false;
    }
    public static boolean checkString(char ch1[], char ch2[]) {
        for(int i=0;i<256;i++) {
            if(ch1[i]!=ch2[i])
                return false;
        }
        return true;
    }
}