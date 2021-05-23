class Solution {
    int isDivisible(String s) {
        int remainder=0;
        for(int i=0;i<s.length();i++) {
            if(remainder==0) {
                if(s.charAt(i)-'0'==1) remainder=1; 
            }
            else if(remainder==1) {
                if(s.charAt(i)-'0'==1) remainder=0;
                else remainder=2;
            }
            else {
                if(s.charAt(i)-'0'==0) remainder=1;
            }
        }
        if(remainder==0) return 1;
        return 0;
        // code here
    }
}
