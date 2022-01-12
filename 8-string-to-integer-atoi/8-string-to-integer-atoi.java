class Solution {
    public int myAtoi(String s) {
        boolean neg = false;
        boolean pos = false;
        Character ch[] = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9'};
        s = s.trim();
        Set<Character> set = new HashSet<>(Arrays.asList(ch));
        StringBuilder sb = new StringBuilder("");
        for(int i=0;i<s.length();i++) {
            if(sb.length()==0  && s.charAt(i)!='-' && s.charAt(i)!='+'  && !set.contains(s.charAt(i))) return 0;
            if(i > 0 && s.charAt(i-1) == '-') {
                if(neg || pos) return 0;
                neg = true;
            }
            if(i > 0 && s.charAt(i-1) == '+') {
                if(neg || pos) return 0;
                pos = true;
            }
            
            if(set.contains(s.charAt(i))) {
                sb.append(s.charAt(i));
            } else if(sb.length() > 0 && !set.contains(s.charAt(i)))
                break;
        }
        long number = 0;
        for(int i=0;i<sb.length();i++) {
            number  = number * 10 + (int)(sb.charAt(i) - 48);
            if(number >= Integer.MAX_VALUE && !neg) return Integer.MAX_VALUE;
            if(-number <= Integer.MIN_VALUE) return Integer.MIN_VALUE;
        }
        if(neg) return -(int)number;
        return (int)number;
    }
}