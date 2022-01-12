class Solution {
    public String reverseWords(String s) {
        String S[] = s.trim().split(" ");
        StringBuilder sb = new StringBuilder("");
        for(int i=S.length-1;i>0;i--) {
            if(!S[i].equals(""))
                sb.append(S[i].trim()+" ");
        }
        sb.append(S[0].trim());
        return sb.toString();
    }
}