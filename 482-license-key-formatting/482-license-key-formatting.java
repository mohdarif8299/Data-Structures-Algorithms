class Solution {
    public String licenseKeyFormatting(String s, int k) {
     s = s.toUpperCase();
     int temp = 0;
     StringBuilder sb = new StringBuilder("");
     for(int i=s.length()-1;i>=0;i--) {
            if(s.charAt(i) == '-') continue;
            if(temp == k) {
                sb.append("-");
                temp = 0;
            } 
            temp++;
            sb.append(s.charAt(i));
        }
        return sb.reverse().toString();
    }
}