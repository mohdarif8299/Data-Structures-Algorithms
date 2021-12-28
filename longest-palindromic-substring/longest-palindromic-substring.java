class Solution {
    public String longestPalindrome(String s) {
        int l=Integer.MIN_VALUE;
        String ans="";
        for(int i=1;i<s.length();i++){
            int p1=i-1;
            int p2=i+1;
            while(p1>=0 && p2<s.length() && s.charAt(p1)==s.charAt(p2)){
                if((p2-p1)+1>l){
                    l=(p2-p1)+1;
                    ans=s.substring(p1,p2+1);
                }
                p1--;
                p2++;
            }
            p1=i-1;
            p2=i;
            while(p1>=0 && p2<s.length() && s.charAt(p1)==s.charAt(p2)){
                if((p2-p1)+1>l){
                    l=(p2-p1)+1;
                    ans=s.substring(p1,p2+1);
                }
                p1--;
                p2++;
            }
        }
        if(ans.length()==0) return s.charAt(0)+"";
        return ans;
        
    }
}